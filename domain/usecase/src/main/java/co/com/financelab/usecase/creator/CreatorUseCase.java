package co.com.financelab.usecase.creator;

import co.com.financelab.model.category.gateways.CategoryRepository;
import co.com.financelab.model.expense.gateways.ExpenseRepository;
import co.com.financelab.model.goal.gateways.GoalRepository;
import co.com.financelab.model.income.gateways.IncomeRepository;
import co.com.financelab.model.subcategory.gateways.SubcategoryRepository;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatorUseCase {
    private final UserRepository userRepository;
    /*private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final GoalRepository goalRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;*/
    public Mono<User> createUser(User user){
        return userRepository.createUser(user);
    }
}
