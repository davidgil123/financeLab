package co.com.financelab.api.util;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.email.FinanceLabEmail;
import co.com.financelab.model.email.gateway.EmailGateways;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.expense.gateways.ExpenseDeleteRequest;
import co.com.financelab.model.goal.Goal;
import co.com.financelab.model.goal.GoalDeleteRequest;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.income.IncomeDeleteRequest;
import co.com.financelab.model.subcategory.Subcategory;
import co.com.financelab.model.subcategory.SubcategoryRequest;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.UserCreateReport;
import co.com.financelab.model.user.UserDeleteRequest;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.List;

@UtilityClass
public class RequestUtil {
    public Mono<String> buildGetAllUser(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("finance-lab"));
    }
    public Mono<User> buidCreateUser(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(User.class);
    }
    public Mono<User> buildUpdateUser(ServerRequest serverRequest){

        return serverRequest.bodyToMono(User.class);
    }
    public Mono<UserDeleteRequest> buildDeleteUser(ServerRequest serverRequest){
        return Mono.just(UserDeleteRequest.builder().financeLabId(serverRequest.headers().firstHeader("finance-lab"))
                .userId(serverRequest.pathVariable("id")).build());
    }

    //Aquí recibimos la petición del front y se la pasamos al caso de uso
    //INCOMES:
    public Mono<String> buildGetAllIncome(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("user-id"));
    }
    public Mono<Income> buidCreateIncome(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(Income.class);
    }
    public Mono<Income> buildUpdateIncome(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Income.class);
    }
    public Mono<IncomeDeleteRequest> buildDeleteIncome(ServerRequest serverRequest){
        return Mono.just(IncomeDeleteRequest.builder().userId(serverRequest.headers().firstHeader("user-id"))
                .incomeId(serverRequest.pathVariable("id")).build());
    }
    //EXPENSES:
    public Mono<String> buildGetAllExpense(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("user-id"));
    }
    public Mono<Expense> buidCreateExpense(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Expense.class);
    }
    public Mono<Expense> buildUpdateExpense(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Expense.class);
    }
    public Mono<ExpenseDeleteRequest> buildDeleteExpense(ServerRequest serverRequest){
        return Mono.just(ExpenseDeleteRequest.builder().userId(serverRequest.headers().firstHeader("user-id"))
                .expenseId(serverRequest.pathVariable("id")).build());
    }
    //GOALS:
    public Mono<String> buildGetAllGoal(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("user-id"));
    }
    public Mono<Goal> buidCreateGoal(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Goal.class);
    }
    public Mono<Goal> buildUpdateGoal(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Goal.class);
    }
    public Mono<GoalDeleteRequest> buildDeleteGoal(ServerRequest serverRequest){
        return Mono.just(GoalDeleteRequest.builder().userId(serverRequest.headers().firstHeader("user-id"))
                .goalId(serverRequest.pathVariable("id")).build());
    }
    //CATEGORIES:
    public Mono<String> buildGetAllCategory(ServerRequest serverRequest){

        return Mono.just(serverRequest.headers().firstHeader("user-id"));
    }
    public Mono<Category> buildCreateCategory(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Category.class);
    }
    //SUBCATEGORIES:
    public Mono<SubcategoryRequest> buildGetAllSubcategories(ServerRequest serverRequest){

        return Mono.just(SubcategoryRequest.builder()
                .categoryId(serverRequest.headers().firstHeader("category-id"))
                .userId(serverRequest.headers().firstHeader("user-id")).build());
    }
    public Mono<SubcategoryRequest> buidCreateSubcategory(ServerRequest serverRequest) {
        return Mono.just(SubcategoryRequest.builder()
                .categoryId(serverRequest.headers().firstHeader("category-id"))
                .userId(serverRequest.headers().firstHeader("user-id"))
                .value(serverRequest.headers().firstHeader("subcategory-value")).build());
    }
    public Mono<UserCreateReport> buildGenerateFile(ServerRequest serverRequest){

        return Mono.just(UserCreateReport.builder()
                .userId(serverRequest.headers().firstHeader("user-id"))
                .month(serverRequest.headers().firstHeader("month"))
                .year(serverRequest.headers().firstHeader("year")).build());
    }
    //ENVIO DE CORREO:
    public Mono<FinanceLabEmail> buildSendEmail(ServerRequest serverRequest){

        return serverRequest.bodyToMono(byte[].class)
                .map(file->
          FinanceLabEmail.builder()
                    .userId(serverRequest.headers().firstHeader("user-id"))
                    .financeLabId(serverRequest.headers().firstHeader("finance-lab"))
                    .file(file).build()
        );
    }


}
