package co.com.financelab.model.goal;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GoalDeleteRequest {
    private String userId;
    private String goalId;
}
