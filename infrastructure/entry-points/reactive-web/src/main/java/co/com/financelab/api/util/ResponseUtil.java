package co.com.financelab.api.util;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.goal.Goal;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.subcategory.Subcategory;
import co.com.financelab.model.user.User;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@UtilityClass

public class ResponseUtil {
    public Mono<ServerResponse> buildResponseAllUser(List<User> userList) {
        return ServerResponse.ok().bodyValue(userList);
    }

    public Mono<ServerResponse> buildResponseCreateUser(User user) {
        user.setPassword("*****");
        return ServerResponse.status(201).bodyValue(user);
    }

    public Mono<ServerResponse> buildResponseUpdateUser(User user) {
        user.setPassword("*****");
        return ServerResponse.ok().bodyValue(user);
    }

    public Mono<ServerResponse> buildResponseDeleteUser(Boolean result) {
        return ServerResponse.ok().bodyValue(result);
    }

    //INCOME
    public Mono<ServerResponse> buildResponseAllIncome(List<Income> incomeList) {
        return ServerResponse.ok().bodyValue(incomeList);
    }

    public Mono<ServerResponse> buildResponseCreateIncome(Income income) {
        return ServerResponse.status(201).bodyValue(income);
    }

    public Mono<ServerResponse> buildResponseUpdateIncome(Income income) {
        return ServerResponse.ok().bodyValue(income);
    }

    public Mono<ServerResponse> buildResponseDeleteIncome(Boolean result) {
        return ServerResponse.ok().bodyValue(result);
    }

    //EXPENSE
    public Mono<ServerResponse> buildResponseAllExpense(List<Expense> expenseList) {
        return ServerResponse.ok().bodyValue(expenseList);
    }

    public Mono<ServerResponse> buildResponseCreateExpense(Expense expense) {
        return ServerResponse.status(201).bodyValue(expense);
    }

    public Mono<ServerResponse> buildResponseUpdateExpense(Expense expense) {
        return ServerResponse.ok().bodyValue(expense);
    }

    public Mono<ServerResponse> buildResponseDeleteExpense(Boolean result) {
        return ServerResponse.ok().bodyValue(result);
    }

    //GOAL
    public Mono<ServerResponse> buildResponseAllGoal(List<Goal> goalList) {
        return ServerResponse.ok().bodyValue(goalList);
    }

    public Mono<ServerResponse> buildResponseCreateGoal(Goal goal) {
        return ServerResponse.status(201).bodyValue(goal);
    }

    public Mono<ServerResponse> buildResponseUpdateGoal(Goal goal) {
        return ServerResponse.ok().bodyValue(goal);
    }

    public Mono<ServerResponse> buildResponseDeleteGoal(Boolean result) {
        return ServerResponse.ok().bodyValue(result);
    }

    //CATEGORY
    public Mono<ServerResponse> buildResponseAllCategory(List<Category> categoryList) {
        return ServerResponse.ok().bodyValue(categoryList);
    }

    public Mono<ServerResponse> buildResponseCreateCategory(Category category) {
        return ServerResponse.status(201).bodyValue(category);
    }
    //SUBCATEGORY
    public Mono<ServerResponse> buildResponseGetAllSubcategories(List<String> subcategoryList) {
        return ServerResponse.ok().bodyValue(subcategoryList);
    }

    public Mono<ServerResponse> buildResponseCreateSubcategory(String subcategory) {
        return ServerResponse.status(201).bodyValue(subcategory);
    }
    public Mono<ServerResponse> buildResponseGenerateFile(byte[] fileReport) {
        return ServerResponse.ok().bodyValue(fileReport);
    }

    public Mono<ServerResponse> buildResponseSendEmail(boolean isOk) {
        return ServerResponse.ok().bodyValue(isOk);
    }
}
