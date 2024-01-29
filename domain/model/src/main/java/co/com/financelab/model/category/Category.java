package co.com.financelab.model.category;
import co.com.financelab.model.subcategory.Subcategory;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Category {
    private String categoryId;
    private String name;
    private List<Subcategory> subcategories;
}
