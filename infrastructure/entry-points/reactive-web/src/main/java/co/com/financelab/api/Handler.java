package co.com.financelab.api;

import co.com.financelab.api.util.RequestUtil;
import co.com.financelab.api.util.ResponseUtil;
import co.com.financelab.usecase.creator.CreatorUseCase;
import co.com.financelab.usecase.deleter.DeleterUseCase;
import co.com.financelab.usecase.lister.ListerUseCase;
import co.com.financelab.usecase.updater.UpdaterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final ListerUseCase listerUseCase;
    private final CreatorUseCase creatorUseCase;
    private final UpdaterUseCase updaterUseCase;
    private final DeleterUseCase deleterUseCase;
    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return RequestUtil.buildGetAllUser(serverRequest).flatMap(listerUseCase::getAllUser).flatMap(ResponseUtil::buildResponseAllUser);
    }
    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        return RequestUtil.buidCreateUser(serverRequest).flatMap(creatorUseCase::createUser).flatMap(ResponseUtil::buildResponseCreateUser);
    }
    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        return RequestUtil.buildUpdateUser(serverRequest).flatMap(updaterUseCase::updateUser).flatMap(ResponseUtil::buildResponseUpdateUser);
    }
    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return RequestUtil.buildDeleteUser(serverRequest).flatMap(deleterUseCase::deleteUser).flatMap(ResponseUtil::buildResponseDeleteUser);
    }

    //Incomes -> Acciones que se pueden ejecutar sobre los incomes
    public Mono<ServerResponse> getAllIncomes(ServerRequest serverRequest) {

        return RequestUtil.buildGetAllIncome(serverRequest).flatMap(listerUseCase::getAllIncome).flatMap(ResponseUtil::buildResponseAllIncome);
    }
    public Mono<ServerResponse> createIncome(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> updateIncome(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> deleteIncome(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    //Expenses -> Acciones que se pueden ejecutar sobre los Expenses
    public Mono<ServerResponse> getAllExpenses(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> createExpenses(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> updateExpenses(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> deleteExpenses(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    //Goals -> Acciones que se pueden ejecutar sobre los Goals
    public Mono<ServerResponse> getAllGoals(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> createGoals(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> updateGoals(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> deleteGoals(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    //Categories -> Acciones que se pueden ejecutar sobre los Categories
    public Mono<ServerResponse> getAllCategories(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> createCategories(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    //Subcategories -> Acciones que se pueden ejecutar sobre los Subcategories
    public Mono<ServerResponse> getAllSubcategories(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
    public Mono<ServerResponse> createSubcategories(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

}
