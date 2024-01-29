package co.com.financelab.dynamodb;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.util.List;

/* Enhanced DynamoDB annotations are incompatible with Lombok #1932
         https://github.com/aws/aws-sdk-java-v2/issues/1932*/
@DynamoDbBean
@Setter
@Getter
public class ModelEntity {
    private String userId;
    private String name;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String email;
    private String country;
    private String city;
    private String birthdayDate;
    private String password;
    private List<Object> actions;
    private String financeLabId;

    public ModelEntity() {
    }

    public ModelEntity(String userId, String name, String lastName, String documentType, String documentNumber, String email, String country, String city, String birthdayDate, String password, List<Object> actions, String financeLabId) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.country = country;
        this.city = city;
        this.birthdayDate = birthdayDate;
        this.password = password;
        this.actions = actions;
        this.financeLabId = financeLabId;
    }

    @DynamoDbPartitionKey
    public String getFinanceLabId() {
        return financeLabId;
    }

    @DynamoDbSortKey
    public String getUserId() {
        return userId;
    }


}
