package co.com.financelab.dynamodb.expense;

import co.com.financelab.dynamodb.helper.TemplateAdapterOperations;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.expense.gateways.ExpenseRepository;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.income.gateways.IncomeRepository;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Repository
public class DynamoDBTemplateAdapterExpense extends TemplateAdapterOperations<Expense, String, ExpenseEntity> implements ExpenseRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapterExpense(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.tableNameExpense}") String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d,Expense.class), tableName);
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
    public Mono<List<Expense>> getAllExpenses(String userId) {

        var queryConditional = generateQueryExpression(userId);

        return super.query(queryConditional);
    }

    @Override
    public Mono<Expense> createExpense(Expense expense) {

        return super.save(expense).thenReturn(expense);
    }

    @Override
    public Mono<Expense> updateExpense(Expense expense) {

        return super.save(expense).thenReturn(expense);
    }

    @Override
    public Mono<Boolean> deleteExpense(String userId, String expenseId) {

        return super.getById(userId, expenseId).flatMap(super::delete).thenReturn(true);
    }
    private Expression applyDateFilter(String date){
        return Expression.builder()
                .expression("contains (#date, :keyword)")
                .expressionNames(Map.of("#date", "date"))
                .expressionValues(Map.of(":keyword", AttributeValue.builder()
                        .s(date).build())).build();
    }
    @Override
    public Mono<List<Expense>> getAllExpensesByMonth(String userId, String date) {
        var expression= applyDateFilter(date);
        var queryConditional = generateQueryExpression(userId).toBuilder()
                .filterExpression(expression)
                .build();

        return super.query(queryConditional);
    }



}
