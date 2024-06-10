package org.example.spartaboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spartaboard.entity.Post;

@NoArgsConstructor
@Getter
@Setter
public class CreatePostResponseDto {
    private long id;
    private User userid;
    private String content;
    private String createAt;
    private String updateAt;


    public CreatePostResponseDto(Post post) {
        this.id = post.getId();
        this.userid = post.getUserid();
        this.content = post.getContent();
        this.createAt = post.getCreateAt();
        this.updateAt = post.getUpdateAt();
    }
}
