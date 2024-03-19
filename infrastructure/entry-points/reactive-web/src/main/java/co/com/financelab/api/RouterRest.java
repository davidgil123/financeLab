package co.com.financelab.api;

import co.com.financelab.api.modelo.FinanceRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouterRest {
    private final Handler handler;
    private final FinanceRoute financeRoute;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET(financeRoute.getListUsers()), handler::getAllUsers)
                .andRoute(POST(financeRoute.getCreateUser()), handler::createUser)
                .andRoute(PATCH(financeRoute.getUpdateUser()), handler::updateUser)
                .andRoute(DELETE(financeRoute.getDeleteUser()), handler::deleteUser)

                .andRoute(GET(financeRoute.getListIncomes()), handler::getAllIncomes)
                .andRoute(POST(financeRoute.getCreateIncome()), handler::createIncome)
                .andRoute(PATCH(financeRoute.getUpdateIncome()), handler::updateIncome)
                .andRoute(DELETE(financeRoute.getDeleteIncome()), handler::deleteIncome)

                .andRoute(GET(financeRoute.getListExpenses()), handler::getAllExpenses)
                .andRoute(POST(financeRoute.getCreateExpense()), handler::createExpense)
                .andRoute(PATCH(financeRoute.getUpdateExpense()), handler::updateExpense)
                .andRoute(DELETE(financeRoute.getDeleteExpense()), handler::deleteExpense)

                .andRoute(GET(financeRoute.getListGoals()), handler::getAllGoals)
                .andRoute(POST(financeRoute.getCreateGoal()), handler::createGoal)
                .andRoute(PATCH(financeRoute.getUpdateGoal()), handler::updateGoal)
                .andRoute(DELETE(financeRoute.getDeleteGoal()), handler::deleteGoal)

                .andRoute(GET(financeRoute.getListCategories()), handler::getAllCategories)
                .andRoute(POST(financeRoute.getCreateCategory()), handler::createCategory)

                .andRoute(GET(financeRoute.getListSubcategories()), handler::getAllSubcategories)
                .andRoute(POST(financeRoute.getCreateSubcategory()), handler::createSubcategory)

                .andRoute(GET(financeRoute.getDownloadFile()), handler::getGenerateFile)
                .andRoute(POST(financeRoute.getSendEmail()), handler::getSendEmail);

    }
}
