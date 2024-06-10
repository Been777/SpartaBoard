package org.example.spartaboard.dto;

import lombok.Getter;
import org.example.spartaboard.entity.Comment;

@Getter
public class CommentRequestDto {
    private String Contents;
    private Long commentid;
    private Long userId;

}
