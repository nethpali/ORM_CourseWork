package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    private String re_enter;
}
