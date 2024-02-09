package co.com.financelab.dynamodb.category;

import co.com.financelab.model.subcategory.Subcategory;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.List;

/* Enhanced DynamoDB annotations are incompatible with Lombok #1932
         https://github.com/aws/aws-sdk-java-v2/issues/1932*/
@DynamoDbBean
@Getter
@Setter
public class CategoryEntity {
    private String userId;
    private String categoryId;
    private String name;
    private List<String> subcategories;

    public CategoryEntity() {

    }

    public CategoryEntity(String userId, String categoryId, String name, List<String> subcategories) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.name = name;
        this.subcategories = subcategories;
    }

    @DynamoDbPartitionKey
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    public String getCategoryId() {
        return categoryId;
    }
}
