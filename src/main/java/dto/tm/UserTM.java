package dto.tm;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTM {
    private String userId;
    private String userName;
    private String password;
    private String re_enter;
}
