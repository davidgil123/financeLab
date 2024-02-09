package co.com.financelab.model.goal;
import co.com.financelab.model.subcategory.Subcategory;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Goal {
    private String userId;
    private String goalId;
    private String date;
    private BigInteger amount;
    private String category;
    private String subCategory;
    private Float goalPercentage;
}
