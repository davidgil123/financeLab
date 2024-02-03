package co.com.financelab.dynamodb.helper;

import org.reactivecommons.utils.ObjectMapper;

import java.lang.reflect.ParameterizedType;

import java.util.List;
import java.util.function.Function;

import reactor.core.publisher.Mono;
import software.amazon.awssdk.core.async.SdkPublisher;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public abstract class TemplateAdapterOperations<E, K, V> {
    private final Class<V> dataClass;
    private final Function<V, E> toEntityFn;
    protected ObjectMapper mapper;
    private final DynamoDbAsyncTable<V> customerTable;
    private final DynamoDbAsyncIndex<V> customerTableByIndex;

    protected TemplateAdapterOperations(DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient, ObjectMapper mapper, Function<V, E> toEntityFn, String tableName, String... index) {
        this.toEntityFn = toEntityFn;
        this.mapper = mapper;
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.dataClass = (Class<V>) genericSuperclass.getActualTypeArguments()[2];
        customerTable = dynamoDbEnhancedAsyncClient.table(tableName, TableSchema.fromBean(dataClass));

        customerTableByIndex = index.length > 0 ? customerTable.index(index[0]) : null;
    }

    public Mono<Void> save(E model) {
        return Mono.fromFuture(customerTable.putItem(toEntity(model)));
    }

    public Mono<E> getById(K id, String sortKey) {
        return Mono.fromFuture(customerTable.getItem(Key.builder().sortValue(AttributeValue.builder().s(sortKey)
                .build()).partitionValue(AttributeValue.builder().s((String) id)
                .build()).build())).map(this::toModel);
    }

    public Mono<E> delete(E model) {
        return Mono.fromFuture(customerTable.deleteItem(toEntity(model))).map(this::toModel);
    }

    public Mono<List<E>> query(QueryEnhancedRequest queryExpression) {
        PagePublisher<V> pagePublisher = customerTable.query(queryExpression);
        return listOfModel(pagePublisher);
    }

    private Mono<List<E>> listOfModel(PagePublisher<V> pagePublisher) {
        return Mono.from(pagePublisher).map(page -> page.items().stream().map(this::toModel).toList());
    }

    protected V toEntity(E model) {
        return mapper.map(model, dataClass);
    }

    protected E toModel(V data) {
        return data != null ? toEntityFn.apply(data) : null;
    }
}