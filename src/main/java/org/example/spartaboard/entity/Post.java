package org.example.spartaboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "post")
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userid; // User Entity 참조 해야함

    @Column(name = "content", nullable = false)
    private String content;

    public Post(User userid, String content) {
        this.content = content;
        this.userid = userid;
    }
    // 유저아이디도 받아와야함
}
