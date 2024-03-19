package co.com.financelab.api;

import co.com.financelab.api.util.RequestUtil;
import co.com.financelab.api.util.ResponseUtil;
import co.com.financelab.usecase.creator.CreatorUseCase;
import co.com.financelab.usecase.deleter.DeleterUseCase;
import co.com.financelab.usecase.generatorfile.GeneratorFileUseCase;
import co.com.financelab.usecase.lister.ListerUseCase;
import co.com.financelab.usecase.senderemail.SenderEmailUseCase;
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
    private final GeneratorFileUseCase generatorFileUseCase;
    private final SenderEmailUseCase senderEmailUseCase;
    public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
        return RequestUtil.buildGetAllUser(serverRequest).flatMap(listerUseCase::getAllUsers).flatMap(ResponseUtil::buildResponseAllUser);
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
        return RequestUtil.buildGetAllIncome(serverRequest).flatMap(listerUseCase::getAllIncomes).flatMap(ResponseUtil::buildResponseAllIncome);
    }
    public Mono<ServerResponse> createIncome(ServerRequest serverRequest) {

        return RequestUtil.buidCreateIncome(serverRequest).flatMap(creatorUseCase::createIncome).flatMap(ResponseUtil::buildResponseCreateIncome);
    }
    public Mono<ServerResponse> updateIncome(ServerRequest serverRequest) {

        return RequestUtil.buildUpdateIncome(serverRequest).flatMap(updaterUseCase::updateIncome).flatMap(ResponseUtil::buildResponseUpdateIncome);
    }
    public Mono<ServerResponse> deleteIncome(ServerRequest serverRequest) {

        return RequestUtil.buildDeleteIncome(serverRequest).flatMap(deleterUseCase::deleteIncome).flatMap(ResponseUtil::buildResponseDeleteIncome);
    }

    //Expenses -> Acciones que se pueden ejecutar sobre los Expenses
    public Mono<ServerResponse> getAllExpenses(ServerRequest serverRequest) {
        return RequestUtil.buildGetAllExpense(serverRequest).flatMap(listerUseCase::getAllExpenses).flatMap(ResponseUtil::buildResponseAllExpense);
    }
    public Mono<ServerResponse> createExpense(ServerRequest serverRequest) {

        return RequestUtil.buidCreateExpense(serverRequest).flatMap(creatorUseCase::createExpense).flatMap(ResponseUtil::buildResponseCreateExpense);
    }
    public Mono<ServerResponse> updateExpense(ServerRequest serverRequest) {

        return RequestUtil.buildUpdateExpense(serverRequest).flatMap(updaterUseCase::updateExpense).flatMap(ResponseUtil::buildResponseUpdateExpense);
    }
    public Mono<ServerResponse> deleteExpense(ServerRequest serverRequest) {

        return RequestUtil.buildDeleteExpense(serverRequest).flatMap(deleterUseCase::deleteExpense).flatMap(ResponseUtil::buildResponseDeleteExpense);
    }

    //Goals -> Acciones que se pueden ejecutar sobre los Goals
    public Mono<ServerResponse> getAllGoals(ServerRequest serverRequest) {

        return RequestUtil.buildGetAllGoal(serverRequest).flatMap(listerUseCase::getAllGoals).flatMap(ResponseUtil::buildResponseAllGoal);
    }
    public Mono<ServerResponse> createGoal(ServerRequest serverRequest) {

        return RequestUtil.buidCreateGoal(serverRequest).flatMap(creatorUseCase::createGoal).flatMap(ResponseUtil::buildResponseCreateGoal);
    }
    public Mono<ServerResponse> updateGoal(ServerRequest serverRequest) {

        return RequestUtil.buildUpdateGoal(serverRequest).flatMap(updaterUseCase::updateGoal).flatMap(ResponseUtil::buildResponseUpdateGoal);
    }
    public Mono<ServerResponse> deleteGoal(ServerRequest serverRequest) {

        return RequestUtil.buildDeleteGoal(serverRequest).flatMap(deleterUseCase::deleteGoal).flatMap(ResponseUtil::buildResponseDeleteGoal);
    }

    //Categories -> Acciones que se pueden ejecutar sobre los Categories
    public Mono<ServerResponse> getAllCategories(ServerRequest serverRequest) {
        return RequestUtil.buildGetAllCategory(serverRequest).flatMap(listerUseCase::getAllCategories).flatMap(ResponseUtil::buildResponseAllCategory);
    }
    public Mono<ServerResponse> createCategory(ServerRequest serverRequest) {
        return RequestUtil.buildCreateCategory(serverRequest).flatMap(creatorUseCase::createCategory).flatMap(ResponseUtil::buildResponseCreateCategory);
    }

    //Subcategories -> Acciones que se pueden ejecutar sobre los Subcategories
    public Mono<ServerResponse> getAllSubcategories(ServerRequest serverRequest) {
        return RequestUtil.buildGetAllSubcategories(serverRequest).flatMap(listerUseCase::getAllSubcategories).flatMap(ResponseUtil::buildResponseGetAllSubcategories);
    }
    public Mono<ServerResponse> createSubcategory(ServerRequest serverRequest) {
        return RequestUtil.buidCreateSubcategory(serverRequest).flatMap(creatorUseCase::createSubcategory).flatMap(ResponseUtil::buildResponseCreateSubcategory);
    }

    //Descarga -> Accion para descarga del archivo consolidado
    public Mono<ServerResponse> getGenerateFile(ServerRequest serverRequest) {
        return RequestUtil.buildGenerateFile(serverRequest).flatMap(generatorFileUseCase::generateFile).
                flatMap(ResponseUtil::buildResponseGenerateFile);
    }
    //Enviar email -> Accion para enviar el archivo consolidado al correo del usuario
    public Mono<ServerResponse> getSendEmail(ServerRequest serverRequest) {
        return RequestUtil.buildSendEmail(serverRequest).flatMap(senderEmailUseCase::sendEmail)
                .flatMap(ResponseUtil::buildResponseSendEmail);
    }


}
