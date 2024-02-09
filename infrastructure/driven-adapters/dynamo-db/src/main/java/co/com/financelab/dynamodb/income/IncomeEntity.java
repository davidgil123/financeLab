package co.com.financelab.dynamodb.income;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

/* Enhanced DynamoDB annotations are incompatible with Lombok #1932
         https://github.com/aws/aws-sdk-java-v2/issues/1932*/
@DynamoDbBean
@Setter
@Getter
public class IncomeEntity {
    private String userId;
    private String incomeId;
    private String date;
    private String amount;
    private String category;
    private String subCategory;

    public IncomeEntity() {

    }

    public IncomeEntity(String userId, String incomeId, String date, String amount, String category, String subCategory) {
        this.userId = userId;
        this.incomeId = incomeId;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.subCategory = subCategory;
    }

    @DynamoDbPartitionKey
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    public String getIncomeId() {
        return incomeId;
    }
}
