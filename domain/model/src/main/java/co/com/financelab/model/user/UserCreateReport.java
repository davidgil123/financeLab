package co.com.financelab.model.user;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserCreateReport {
    private String userId;
    private String financeLabId;
    private String month;
    private String year;
}
