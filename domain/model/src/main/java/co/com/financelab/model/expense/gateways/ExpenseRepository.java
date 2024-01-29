package co.com.financelab.model.expense.gateways;

import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.income.Income;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ExpenseRepository {
    Mono<List<Expense>> getAllExpenses(String finnanceLab, String userId);
    Mono<Expense> createExpense(String finnanceLab, String userId, Expense expense);
    Mono<Expense> updateExpense(String finnanceLab, String userId, String expenseId);
    Mono<Boolean> deleteExpense(String finnanceLab, String userId, String expenseId);
}
