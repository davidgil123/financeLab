package co.com.financelab.usecase.deleter;

import co.com.financelab.model.expense.gateways.ExpenseRepository;
import co.com.financelab.model.goal.gateways.GoalRepository;
import co.com.financelab.model.income.gateways.IncomeRepository;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.UserDeleteRequest;
import co.com.financelab.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleterUseCase {
    private final UserRepository userRepository;
    /*private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final GoalRepository goalRepository;*/
    public Mono<Boolean> deleteUser(UserDeleteRequest userDeleteRequest) {
        return userRepository.deleteUser(userDeleteRequest.getFinanceLabId(), userDeleteRequest.getUserId() );
    }
}
