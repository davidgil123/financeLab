package co.com.financelab.api.modelo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "routes.paths")
public class FinanceRoute {
    private String listUser;
    private String createUser;
    private String updateUser;
    private String deleteUser;

    private String listIncomes;
    private String createIncomes;
    private String updateIncomes;
    private String deleteIncomes;

    private String listExpenses;
    private String createExpenses;
    private String updateExpenses;
    private String deleteExpenses;

    private String listGoals;
    private String createGoals;
    private String updateGoals;
    private String deleteGoals;

    private String listCategories;
    private String createCategories;

    private String listSubcategories;
    private String createSubcategories;
}
