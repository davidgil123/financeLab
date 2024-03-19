package co.com.financelab.model.email;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class FinanceLabEmail {
    private String financeLabId;
    private String userId;
    private byte[] file;
}
