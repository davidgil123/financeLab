package co.com.financelab.dynamodb.goal;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.math.BigInteger;

/* Enhanced DynamoDB annotations are incompatible with Lombok #1932
         https://github.com/aws/aws-sdk-java-v2/issues/1932*/
@DynamoDbBean
@Setter
@Getter
public class GoalEntity {
    private String userId;
    private String goalId;
    private String date;
    private BigInteger amount;
    private String category;
    private String subCategory;
    private Float goalPercentage;

    public GoalEntity() {

    }

    public GoalEntity(String userId, String goalId, String date, BigInteger amount, String category, String subCategory, Float goalPercentage) {
        this.userId = userId;
        this.goalId = goalId;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.subCategory = subCategory;
        this.goalPercentage = goalPercentage;

}

    @DynamoDbPartitionKey
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    public String getGoalId() {
        return goalId;
    }
}
