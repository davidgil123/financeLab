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
    private String listUsers;
    private String createUser;
    private String updateUser;
    private String deleteUser;

    private String listIncomes;
    private String createIncome;
    private String updateIncome;
    private String deleteIncome;

    private String listExpenses;
    private String createExpense;
    private String updateExpense;
    private String deleteExpense;

    private String listGoals;
    private String createGoal;
    private String updateGoal;
    private String deleteGoal;

    private String listCategories;
    private String createCategory;

    private String listSubcategories;
    private String createSubcategory;
}
