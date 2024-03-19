package co.com.financelab.model.expense;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Expense {
    private String userId;
    private String expenseId;
    private String date;
    private String amount;
    private String category;
    private String subCategory;
}
