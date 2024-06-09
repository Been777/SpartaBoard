package org.example.spartaboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Post2(User user, String content) {
        this.user = user;
        this.content = content;
    }
}
