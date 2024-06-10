package org.example.spartaboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spartaboard.dto.CreatePostRequestDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "post")
public class Post {
    Date today = new Date();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid; // User Entity 참조 해야함

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate
    private String createAt;

    @LastModifiedDate
    private String updateAt;

    public Post(CreatePostRequestDto createPostRequestDto) {
        this.content = createPostRequestDto.getContent();
    }
    // 유저아이디도 받아와야함
}
