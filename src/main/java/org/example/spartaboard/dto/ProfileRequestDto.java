package org.example.spartaboard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProfileRequestDto {

    @NotBlank(message = "ID를 입력해주세요.")
    private String userId;
    @NotBlank(message = "password를 입력해주세요.")
    private String password;


}
