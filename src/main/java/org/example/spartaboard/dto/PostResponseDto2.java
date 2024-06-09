package org.example.spartaboard.dto;

import org.example.spartaboard.entity.Post2;
import org.example.spartaboard.entity.User;

import java.util.Date;

public class PostResponseDto2 {

    Date today = new Date();
//    public static Long user_id; 유저아이디가 필요할것 예비
    public String content;
    public final String date = today.toString();
    public String dateNow;
    public PostResponseDto2(Post2 post) {
        this.content = post.getContent();
        this.dateNow = post.getDate();
    }
}
