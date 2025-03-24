package web.model.dto;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web.model.entity.UserEntity;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private int uindex;
    private String uname;
    private String email;
    private String password;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .uindex(this.uindex)
                .uname(this.uname)
                .email(this.email)
                .password(new BCryptPasswordEncoder().encode(this.password))
                .build();
    }
}
