package org.example.spartaboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.spartaboard.dto.PostResponseDto2;

@Getter
@Entity
@NoArgsConstructor
@Table(name="post")
public class Post2 extends Timestamped {

    @Id //찾을 때 추천(고유)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") //직접 적는 게 아닌데 nullable = false 가 필요할까?
    private User user;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String date;

    public Post2(User user, String content, String date) {
        this.user = user;
        this.content = content;
        this.date = date; // 자동 생성된 날짜 엔티티
    }

    public Post2(Post2 id,PostResponseDto2 postRequestDto2) {
        super();
    this.id= id.getId();
    this.content =postRequestDto2.content;
    this.date = postRequestDto2.date;
    }
}
