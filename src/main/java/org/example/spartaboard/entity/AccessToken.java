package org.example.spartaboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AccessToken extends Timestamped {

    @Id //고유
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column //access 토큰 이름
    private String accessToken;
    @Column //access 토큰 생성 시간
    private String accessTokenCreatedAt;

}
