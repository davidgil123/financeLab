package co.com.financelab.dynamodb.user;

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
public class DynamoDBTemplateAdapterUser extends TemplateAdapterOperations<User, String, UserEntity> implements UserRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapterUser(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.tableNameUser}") String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d,User.class), tableName);
    }

    private QueryEnhancedRequest generateQueryExpression(String partitionKey) {
        var queryConditional = QueryConditional.sortGreaterThanOrEqualTo(Key.builder()
                .partitionValue(AttributeValue.builder().s(partitionKey).build())
                .sortValue(AttributeValue.builder().s(SORT_KEY).build()).build());
        return QueryEnhancedRequest.builder()
                .queryConditional(queryConditional)
                .build();
    }

    @Override
    public Mono<List<User>> getAllUser(String financeLab) {

        var queryConditional = generateQueryExpression(financeLab);

        return super.query(queryConditional);
    }

    @Override
    public Mono<User> createUser(User user) {

        return super.save(user).thenReturn(user);
    }

    @Override
    public Mono<User> updateUser(User user) {

        return super.save(user).thenReturn(user);
    }

    @Override
    public Mono<Boolean> deleteUser(String financelab  , String userId) {

        return super.getById(financelab, userId).flatMap(super::delete).thenReturn(true);
    }

    @Override
    public Mono<User> getUserById(String financelab, String userId) {
        return super.getById(financelab, userId);
    }

}
