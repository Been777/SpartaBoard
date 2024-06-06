package org.example.spartaboard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.spartaboard.dto.ProfileModifyRequestDto;

@Getter
@Entity
@NoArgsConstructor
@Table(name="user")
public class User extends Timestamped{

    @Id //찾을 때 추천(고유)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String introduce;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;


    //refresh token 설정 필요


    public void update(ProfileModifyRequestDto requestDto) {
        if (requestDto.getUsername() != null) {
            this.username = requestDto.getUsername();
        }
        if (requestDto.getIntroduce() != null) {
            this.introduce = requestDto.getIntroduce();
        }
        if (requestDto.getNewPassword() != null) {
            this.password = requestDto.getNewPassword();
        }

    }


}
