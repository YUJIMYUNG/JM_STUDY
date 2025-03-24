package web.model.entity;

import jakarta.persistence.*;
import lombok.*;
import web.model.dto.UserDto;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "category")
public class UserEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uindex;

    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String uname;


    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255)", nullable = false, unique = true)
    private String password;

    public UserDto toDto() {
        return UserDto.builder()
                .uindex(this.uindex)
                .uname(this.uname)
                .password(this.password)
                .email(this.email)
                .build();
    }




}
