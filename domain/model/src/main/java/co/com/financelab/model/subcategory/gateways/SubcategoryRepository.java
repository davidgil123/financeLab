package co.com.financelab.model.subcategory.gateways;

import co.com.financelab.model.category.Category;
import co.com.financelab.model.subcategory.Subcategory;
import co.com.financelab.model.subcategory.SubcategoryRequest;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SubcategoryRepository {
    Mono<List<String>> getAllSubcategories(SubcategoryRequest subcategoryRequest);
    Mono<String> createSubcategory(SubcategoryRequest subcategoryRequest);
}
