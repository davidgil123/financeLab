package co.com.financelab.model.income;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Income {
    private String incomeId;
    private String date;
    private String amount;
    private String category;
    private String subCategory;
}
