package co.com.financelab.usecase.creator;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.category.gateways.CategoryRepository;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.expense.gateways.ExpenseRepository;
import co.com.financelab.model.goal.Goal;
import co.com.financelab.model.goal.gateways.GoalRepository;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.income.gateways.IncomeRepository;
import co.com.financelab.model.subcategory.SubcategoryRequest;
import co.com.financelab.model.subcategory.gateways.SubcategoryRepository;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class CreatorUseCase {
    private final UserRepository userRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final GoalRepository goalRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public Mono<User> createUser(User user){

        return userRepository.createUser(user);
    }
    public Mono<Income> createIncome(Income income){

        return incomeRepository.createIncome(income);
    }
    public Mono<Expense> createExpense(Expense expense){

        return expenseRepository.createExpense(expense);
    }
    public Mono<Goal> createGoal(Goal goal){

        return goalRepository.createGoal(goal);
    }
    public Mono<Category> createCategory(Category category){

        return categoryRepository.createCategory(category);
    }
    public Mono<String> createSubcategory(SubcategoryRequest subcategoryRequest){

        return subcategoryRepository.createSubcategory(subcategoryRequest);
    }
}
