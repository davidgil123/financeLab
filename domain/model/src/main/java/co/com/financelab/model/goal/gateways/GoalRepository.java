package co.com.financelab.model.goal.gateways;

import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.goal.Goal;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GoalRepository {
    Mono<List<Goal>> getAllGoals(String finnanceLab, String userId);
    Mono<Goal> createGoal(String finnanceLab, String userId, Goal goal);
    Mono<Goal> updateGoal(String finnanceLab, String userId, String goalId);
    Mono<Boolean> deleteGoal(String finnanceLab, String userId, String goalId);
}
