package co.com.financelab.dynamodb.income;

import co.com.financelab.dynamodb.helper.TemplateAdapterOperations;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.income.gateways.IncomeRepository;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.Map;


@Repository
public class DynamoDBTemplateAdapterIncome extends TemplateAdapterOperations<Income, String, IncomeEntity> implements IncomeRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapterIncome(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.tableNameIncome}") String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d,Income.class), tableName);
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
    public Mono<List<Income>> getAllIncome(String userId) {

        var queryConditional = generateQueryExpression(userId);

        return super.query(queryConditional);
    }

    @Override
    public Mono<Income> createIncome(Income income) {

        return super.save(income).thenReturn(income);
    }

    @Override
    public Mono<Income> updateIncome(Income income) {

        return super.save(income).thenReturn(income);
    }

    @Override
    public Mono<Boolean> deleteIncome(String userId, String incomeId) {

        return super.getById(userId, incomeId).flatMap(super::delete).thenReturn(true);
    }
    private Expression applyDateFilter(String date){
        return Expression.builder()
                .expression("contains (#date, :keyword)")
                .expressionNames(Map.of("#date", "date"))
                .expressionValues(Map.of(":keyword", AttributeValue.builder()
                        .s(date).build())).build();
    }
    @Override
    public Mono<List<Income>> getAllIncomesByMonth(String userId, String date) {
        var expression= applyDateFilter(date);
        var queryConditional = generateQueryExpression(userId).toBuilder()
                .filterExpression(expression)
                .build();

        return super.query(queryConditional);
    }

}
