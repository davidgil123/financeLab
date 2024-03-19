package co.com.financelab.model.income;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Income {
    private String userId;
    private String incomeId;
    private String date;
    private String amount;
    private String category;
    private String subCategory;
}
