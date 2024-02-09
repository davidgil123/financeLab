package co.com.financelab.model.subcategory;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Subcategory {
    private String subcategoryId;
    private String name;
}
