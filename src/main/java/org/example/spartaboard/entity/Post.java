package org.example.spartaboard.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "posts")
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Post(String title, String contents, User user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
    }

    public void update(String title, String contents) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        }

        if (contents != null && !contents.isBlank()) {
            this.contents = contents;
        }
    }
}