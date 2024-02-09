package co.com.financelab.model.income;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class IncomeDeleteRequest {
    private String userId;
    private String incomeId;
}
