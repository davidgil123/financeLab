package co.com.financelab.model.income.gateways;

import co.com.financelab.model.income.Income;
import co.com.financelab.model.user.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IncomeRepository {
    Mono<List<Income>> getAllIncomes(String financeLab, String userId);
    Mono<Income> createIncome(String financeLab, String userId, Income income);
    Mono<Income> updateIncome(String financeLab, String userId, String incomeId);
    Mono<Boolean> deleteIncome(String financeLab, String userId, String incomeId);
}
