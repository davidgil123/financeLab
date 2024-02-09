package co.com.financelab.dynamodb.category;

import co.com.financelab.dynamodb.helper.TemplateAdapterOperations;
import co.com.financelab.dynamodb.user.UserEntity;
import co.com.financelab.model.category.Category;
import co.com.financelab.model.category.gateways.CategoryRepository;
import co.com.financelab.model.subcategory.SubcategoryRequest;
import co.com.financelab.model.subcategory.gateways.SubcategoryRepository;
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

import java.util.ArrayList;
import java.util.List;


@Repository
public class DynamoDBTemplateAdapterCategory extends TemplateAdapterOperations<Category, String, CategoryEntity> implements CategoryRepository, SubcategoryRepository {

    private static final String SORT_KEY= "\u0000";
    public DynamoDBTemplateAdapterCategory(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper, @Value("${aws.dynamodb.tableNameCategory}") String tableName) {

        super(connectionFactory, mapper, d -> mapper.map(d,Category.class), tableName);
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
    public Mono<List<Category>> getAllCategories(String financeLab) {

        var queryConditional = generateQueryExpression(financeLab);

        return super.query(queryConditional);
    }

    @Override
    public Mono<Category> createCategory(Category category) {

        return super.save(category).thenReturn(category);
    }


    @Override
    public Mono<List<String>> getAllSubcategories(SubcategoryRequest subcategoryRequest) {
        return super.getById(subcategoryRequest.getUserId(),subcategoryRequest.getCategoryId())
                .flatMap(this::getSubcategories);
    }

    @Override
    public Mono<String> createSubcategory(SubcategoryRequest subcategoryRequest) {
        return super.getById(subcategoryRequest.getUserId(),subcategoryRequest.getCategoryId())
                .flatMap(category -> setSubcategory(category, subcategoryRequest.getValue()))
                .flatMap(super::save).flatMap(category2->Mono.just(subcategoryRequest.getValue()));
    }

    private Mono<List<String>> getSubcategories(Category category){
        List<String> subcategoryList=new ArrayList<String>();
        subcategoryList=category.getSubcategories();
        return Mono.just(subcategoryList);
    }
    private Mono<Category> setSubcategory(Category category, String subcategory){
        var subcategoryList= category.getSubcategories();
        subcategoryList.add(subcategory);
        category.setSubcategories(subcategoryList);
        return Mono.just(category);
    }
}
