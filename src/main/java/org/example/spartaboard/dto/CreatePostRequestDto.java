package org.example.spartaboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.spartaboard.entity.User;

@Getter
@Setter
public class CreatePostRequestDto {
    private String content;
    private User userid;
}
