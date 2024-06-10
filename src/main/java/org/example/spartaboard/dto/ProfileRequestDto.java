package org.example.spartaboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ProfileRequestDto {
    private String userid;

    public ProfileRequestDto(String userid) {
        this.userid = userid;
    }
}