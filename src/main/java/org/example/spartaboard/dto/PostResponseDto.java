package org.example.spartaboard.dto;

import lombok.Getter;
import org.example.spartaboard.entity.Post;
@Getter

public class PostResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String userId;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.userId = post.getUser().getUserId();

    }

}
