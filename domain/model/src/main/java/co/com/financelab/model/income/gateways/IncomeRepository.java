package co.com.financelab.model.income.gateways;

import co.com.financelab.model.income.Income;
import co.com.financelab.model.user.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IncomeRepository {
    Mono<List<Income>> getAllIncomes(String finnanceLab, String userId);
    Mono<Income> createIncome(String finnanceLab, String userId, Income income);
    Mono<Income> updateIncome(String finnanceLab, String userId, String incomeId);
    Mono<Boolean> deleteIncome(String finnanceLab, String userId, String incomeId);
}
