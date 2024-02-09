package co.com.financelab.model.goal.gateways;

import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.goal.Goal;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GoalRepository {
    Mono<List<Goal>> getAllGoals(String userId);
    Mono<Goal> createGoal(Goal goal);
    Mono<Goal> updateGoal(Goal goal);
    Mono<Boolean> deleteGoal(String userId, String goalId);
}
