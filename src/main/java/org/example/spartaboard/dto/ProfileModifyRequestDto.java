package org.example.spartaboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileModifyRequestDto {
    private String username;
    private String email;
    private String introduce;
    private String oldPassword;
    private String newPassword;
}