package org.example.spartaboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.spartaboard.entity.Post;

@Getter
@Setter
public class CreatePostResponseDto {
    private long id;
    private String content;

    public CreatePostResponseDto(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
    }
}
