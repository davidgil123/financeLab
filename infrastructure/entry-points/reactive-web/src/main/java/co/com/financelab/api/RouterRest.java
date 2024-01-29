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
        return route(GET(financeRoute.getListUser()), handler::getAllUsers)
                .andRoute(POST(financeRoute.getCreateUser()), handler::createUser)
                .andRoute(PATCH(financeRoute.getUpdateUser()), handler::updateUser)
                .andRoute(DELETE(financeRoute.getDeleteUser()), handler::deleteUser)

                .andRoute(GET(financeRoute.getListIncomes()), handler::getAllIncomes)
                .andRoute(POST(financeRoute.getCreateIncomes()), handler::createIncome)
                .andRoute(PATCH(financeRoute.getUpdateIncomes()), handler::updateIncome)
                .andRoute(DELETE(financeRoute.getDeleteIncomes()), handler::deleteIncome)

                .andRoute(GET(financeRoute.getListExpenses()), handler::getAllExpenses)
                .andRoute(POST(financeRoute.getCreateExpenses()), handler::createExpenses)
                .andRoute(PATCH(financeRoute.getUpdateExpenses()), handler::updateExpenses)
                .andRoute(DELETE(financeRoute.getDeleteExpenses()), handler::deleteExpenses)

                .andRoute(GET(financeRoute.getListGoals()), handler::getAllGoals)
                .andRoute(POST(financeRoute.getCreateGoals()), handler::createGoals)
                .andRoute(PATCH(financeRoute.getUpdateGoals()), handler::updateGoals)
                .andRoute(DELETE(financeRoute.getDeleteGoals()), handler::deleteGoals)

                .andRoute(GET(financeRoute.getListCategories()), handler::getAllCategories)
                .andRoute(POST(financeRoute.getCreateCategories()), handler::createCategories)

                .andRoute(GET(financeRoute.getListSubcategories()), handler::getAllSubcategories)
                .andRoute(POST(financeRoute.getCreateSubcategories()), handler::createSubcategories)
                ;
    }
}
