package co.com.financelab.model.user;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDeleteRequest {
    private String userId;
    private String financeLabId;
}
