package dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String userId;
    private String userName;
    private String password;
    private String re_enter;
}
