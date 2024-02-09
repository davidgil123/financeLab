package co.com.financelab.model.category;
import co.com.financelab.model.subcategory.Subcategory;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Category {
    private String userId;
    private String categoryId;
    private String name;
    @Setter
    private List<String> subcategories;
}
