package co.com.financelab.model.category.gateways;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.goal.Goal;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryRepository {
    Mono<List<Category>> getAllCategories(String finnanceLab, String userId);
    Mono<Category> createCategory(String finnanceLab, String userId, Category category);
}
