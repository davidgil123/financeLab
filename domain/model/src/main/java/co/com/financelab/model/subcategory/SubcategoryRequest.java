package co.com.financelab.model.subcategory;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryRequest {
    private String userId;
    private String categoryId;
    private String value;
}
