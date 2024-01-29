package co.com.financelab.model.subcategory.gateways;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.subcategory.Subcategory;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SubcategoryRepository {
    Mono<List<Subcategory>> getAllSubcategories(String finnanceLab, String userId, String categoryId);
    Mono<Subcategory> createSubcategory(String finnanceLab, String userId, String categoryId, Subcategory subcategory);
}
