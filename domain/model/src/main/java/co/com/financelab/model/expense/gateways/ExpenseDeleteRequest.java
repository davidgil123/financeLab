package co.com.financelab.model.expense.gateways;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ExpenseDeleteRequest {
    private String userId;
    private String expenseId;
}
