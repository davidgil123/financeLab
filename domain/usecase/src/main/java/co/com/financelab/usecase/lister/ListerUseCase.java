package co.com.financelab.usecase.lister;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.category.gateways.CategoryRepository;
import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.expense.gateways.ExpenseRepository;
import co.com.financelab.model.goal.Goal;
import co.com.financelab.model.goal.gateways.GoalRepository;
import co.com.financelab.model.income.Income;
import co.com.financelab.model.income.gateways.IncomeRepository;
import co.com.financelab.model.subcategory.Subcategory;
import co.com.financelab.model.subcategory.SubcategoryRequest;
import co.com.financelab.model.subcategory.gateways.SubcategoryRepository;
import co.com.financelab.model.user.User;
import co.com.financelab.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ListerUseCase {
    private final UserRepository userRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final GoalRepository goalRepository;
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    public Mono<List<User>> getAllUsers(String financeLab){

        return userRepository.getAllUser(financeLab);
    }
    public Mono<List<Income>> getAllIncomes(String userId){

        return incomeRepository.getAllIncome(userId);
    }
    public Mono<List<Expense>> getAllExpenses(String userId){

        return expenseRepository.getAllExpenses(userId);
    }
    public Mono<List<Goal>> getAllGoals(String userId){

        return goalRepository.getAllGoals(userId);
    }
    public Mono<List<Category>> getAllCategories(String userId){

        return categoryRepository.getAllCategories(userId);
    }
    public Mono<List<String>> getAllSubcategories(SubcategoryRequest subcategoryRequest){

        return subcategoryRepository.getAllSubcategories(subcategoryRequest);
    }
}
