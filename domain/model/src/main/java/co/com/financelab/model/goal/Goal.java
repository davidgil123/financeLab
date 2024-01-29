package co.com.financelab.model.goal;
import co.com.financelab.model.subcategory.Subcategory;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Goal {
    private String goalId;
    private String date;
    private BigInteger amount;
    private String category;
    private String subCategory;
    private Float goalPercentage;
}
