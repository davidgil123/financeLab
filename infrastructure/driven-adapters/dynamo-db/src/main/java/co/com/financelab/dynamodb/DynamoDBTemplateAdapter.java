package co.com.financelab.dynamodb;

import co.com.financelab.dynamodb.helper.TemplateAdapterOperations;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;


@Repository
public class DynamoDBTemplateAdapter extends TemplateAdapterOperations<User, String, ModelEntity> implements UserRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper,@Value("${aws.dynamodb.tableName}") String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d,User.class), tableName);
    }

    private QueryEnhancedRequest generateQueryExpression(String partitionKey) {
        return QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.keyEqualTo(Key.builder().partitionValue(AttributeValue.builder().s(partitionKey).build()).build()))
                .queryConditional(QueryConditional.sortGreaterThanOrEqualTo(Key.builder().sortValue(AttributeValue.builder().s(SORT_KEY).build()).build()))
                .build();
    }

    @Override
    public Mono<List<User>> getAllUser(String financeLab) {

        var queryConditional = generateQueryExpression(financeLab);

        return super.query(queryConditional);
    }

    @Override
    public Mono<User> createUser(String financelab, User user) {
        return null;
    }

    @Override
    public Mono<User> updateUser(String financelab, String userId) {
        return null;
    }

    @Override
    public Mono<Boolean> deleteUser(String financelab, String userId) {
        return null;
    }
}
