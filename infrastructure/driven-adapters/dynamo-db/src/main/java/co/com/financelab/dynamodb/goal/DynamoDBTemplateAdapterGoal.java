package co.com.financelab.dynamodb.goal;

import co.com.financelab.dynamodb.helper.TemplateAdapterOperations;
import co.com.financelab.model.goal.Goal;
import co.com.financelab.model.goal.gateways.GoalRepository;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.income.gateways.IncomeRepository;
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
public class DynamoDBTemplateAdapterGoal extends TemplateAdapterOperations<Goal, String, GoalEntity> implements GoalRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapterGoal(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.tableNameGoal}") String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d,Goal.class), tableName);
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
    public Mono<List<Goal>> getAllGoals(String userId) {

        var queryConditional = generateQueryExpression(userId);

        return super.query(queryConditional);
    }

    @Override
    public Mono<Goal> createGoal(Goal goal) {

        return super.save(goal).thenReturn(goal);
    }

    @Override
    public Mono<Goal> updateGoal(Goal goal) {

        return super.save(goal).thenReturn(goal);
    }

    @Override
    public Mono<Boolean> deleteGoal(String userId, String goalId) {

        return super.getById(userId, goalId).flatMap(super::delete).thenReturn(true);
    }

}
