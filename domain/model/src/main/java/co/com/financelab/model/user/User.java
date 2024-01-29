package co.com.financelab.model.user;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private String userId;
    private String name;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String email;
    private String country;
    private String city;
    private String birthdayDate;
    private String password;
    private List<Object> actions;
    private String financeLabId;

}
