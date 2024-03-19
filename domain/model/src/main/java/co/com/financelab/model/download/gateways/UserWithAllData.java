package co.com.financelab.model.download.gateways;

import co.com.financelab.model.expense.Expense;
import co.com.financelab.model.income.Income;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserWithAllData {
    private String userId;
    private List<Income> incomeList;
    private List<Expense> expenseList;

}
