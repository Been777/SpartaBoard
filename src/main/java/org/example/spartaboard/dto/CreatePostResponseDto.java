package org.example.spartaboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spartaboard.entity.Post;
import org.example.spartaboard.entity.Timestamped;
import org.example.spartaboard.entity.User;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CreatePostResponseDto extends Timestamped {
    private long id;
    private User userid;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    //LocalDateTime getCreatedAt, LocalDateTime getUpdateAt
    public CreatePostResponseDto(Post post) {
        this.id = post.getId();
        this.userid = post.getUserid();
        this.content = post.getContent();
        this.createAt = post.getCreateAt();
        this.updateAt = post.getUpdateAt();
    }
}
