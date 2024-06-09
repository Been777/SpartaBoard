package org.example.spartaboard.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaboard.Security.UserDetailsImpl;
import org.example.spartaboard.dto.PostResponseDto2;
import org.example.spartaboard.service.PostService2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/post"))
public class PostController2 {

    private final PostService2 postService;

    // 게시글 전체 조회 (모든 사용자-로그인한 사람-가 전체 게시물 조회)
    @GetMapping("/all") // 또는 /api/posts 라고 해도 될 것 같음
    public ResponseEntity<List<PostResponseDto2>> ShowPost(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.showPost(userDetails.getUser().getId());
    }
}
