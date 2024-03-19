package co.com.financelab.usecase.generatorfile;

import co.com.financelab.model.download.gateways.DownloadGateway;
import co.com.financelab.model.download.gateways.UserWithAllData;
import co.com.financelab.model.expense.gateways.ExpenseRepository;
import co.com.financelab.model.income.gateways.IncomeRepository;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.UserCreateReport;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
public class GeneratorFileUseCase {
    private final DownloadGateway downloadGateway;
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    public Mono<byte[]> generateFile(UserCreateReport userCreateReport) {
        var dateToSearch = String.format("/%s/%s", userCreateReport.getMonth(), userCreateReport.getYear());
        UserWithAllData superUser = new UserWithAllData();
        superUser.setUserId(userCreateReport.getUserId());
        return expenseRepository.getAllExpensesByMonth(userCreateReport.getUserId(), dateToSearch)
                .flatMap(expenseList -> {
                    superUser.setExpenseList(expenseList);
                    return incomeRepository.getAllIncomesByMonth(userCreateReport.getUserId(), dateToSearch)
                            .flatMap(incomeList -> {
                                superUser.setIncomeList(incomeList);
                                return Mono.just(superUser);
                            });
                }).flatMap(downloadGateway::generateFile);
    }
}
