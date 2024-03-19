package co.com.financelab.model.expense.gateways;

import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.income.Income;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ExpenseRepository {
    Mono<List<Expense>> getAllExpenses(String userId);
    Mono<Expense> createExpense(Expense expense);
    Mono<Expense> updateExpense(Expense expense);
    Mono<Boolean> deleteExpense(String userId, String expenseId);
    Mono<List<Expense>> getAllExpensesByMonth(String userId, String date);
}
