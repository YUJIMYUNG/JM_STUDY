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
    private String nickname;
    private String email;
    private String password;

    private String signupdate;
    private String modificationdate;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .uindex(this.uindex)
                .nickname(this.nickname)
                .email(this.email)
                .password(new BCryptPasswordEncoder().encode(this.password))
                .build();
    }
}
