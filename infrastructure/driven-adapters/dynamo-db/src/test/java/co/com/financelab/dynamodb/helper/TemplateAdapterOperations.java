package co.com.financelab.dynamodb.helper;

import co.com.financelab.dynamodb.user.DynamoDBTemplateAdapterUser;
import co.com.financelab.dynamodb.user.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import reactor.test.StepVerifier;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TemplateAdapterOperationsTest {

    @Mock
    private DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient;

    @Mock
    private ObjectMapper mapper;

    @Mock
    private DynamoDbAsyncTable<UserEntity> customerTable;

    private UserEntity modelEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(dynamoDbEnhancedAsyncClient.table("table_name", TableSchema.fromBean(UserEntity.class)))
                .thenReturn(customerTable);

        modelEntity = new UserEntity();
        modelEntity.setId("id");
        modelEntity.setAtr1("atr1");
    }

    @Test
    void modelEntityPropertiesMustNotBeNull() {
        UserEntity modelEntityUnderTest = new UserEntity("id", "atr1");

        assertNotNull(modelEntityUnderTest.getId());
        assertNotNull(modelEntityUnderTest.getAtr1());
    }

    @Test
    void testSave() {
        when(customerTable.putItem(modelEntity)).thenReturn(CompletableFuture.runAsync(()->{}));
        when(mapper.map(modelEntity, UserEntity.class)).thenReturn(modelEntity);

        DynamoDBTemplateAdapterUser dynamoDBTemplateAdapterUser =
                new DynamoDBTemplateAdapterUser(dynamoDbEnhancedAsyncClient, mapper);

        StepVerifier.create(dynamoDBTemplateAdapterUser.save(modelEntity))
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void testGetById() {
        String id = "id";

        when(customerTable.getItem(
                Key.builder().partitionValue(AttributeValue.builder().s(id).build()).build()))
                .thenReturn(CompletableFuture.completedFuture(modelEntity));
        when(mapper.map(modelEntity, Object.class)).thenReturn("value");

        DynamoDBTemplateAdapterUser dynamoDBTemplateAdapterUser =
                new DynamoDBTemplateAdapterUser(dynamoDbEnhancedAsyncClient, mapper);

        StepVerifier.create(dynamoDBTemplateAdapterUser.getById("id"))
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testDelete() {
        when(mapper.map(modelEntity, UserEntity.class)).thenReturn(modelEntity);
        when(mapper.map(modelEntity, Object.class)).thenReturn("value");

        when(customerTable.deleteItem(modelEntity))
                .thenReturn(CompletableFuture.completedFuture(modelEntity));

        DynamoDBTemplateAdapterUser dynamoDBTemplateAdapterUser =
                new DynamoDBTemplateAdapterUser(dynamoDbEnhancedAsyncClient, mapper);

        StepVerifier.create(dynamoDBTemplateAdapterUser.delete(modelEntity))
                .expectNext("value")
                .verifyComplete();
    }
}