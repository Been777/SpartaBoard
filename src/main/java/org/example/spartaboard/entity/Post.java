package org.example.spartaboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spartaboard.dto.CreatePostRequestDto;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false)
    private String content;

    public Post(CreatePostRequestDto createPostRequestDto) {
        this.content = createPostRequestDto.getContent();
    }
    // 유저아이디도 받아와야함
}
