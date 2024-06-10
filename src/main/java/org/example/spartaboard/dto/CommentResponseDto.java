package org.example.spartaboard.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spartaboard.entity.Comment;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto  {
    private Long id;
    private String contents;
    private Long userId;


    public CommentResponseDto(Long id, String contents, Long userId) {
        this.id = id;
        this.contents = contents;
        this.userId = userId;
    }


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.userId=getUserId();
    }
}
