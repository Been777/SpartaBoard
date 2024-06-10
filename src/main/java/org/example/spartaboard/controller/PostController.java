package org.example.spartaboard.controller;

import org.example.spartaboard.dto.CreatePostRequestDto;
import org.example.spartaboard.dto.CreatePostResponseDto;
import org.example.spartaboard.entity.Post;
import org.example.spartaboard.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    public CreatePostResponseDto createPost(@RequestBody CreatePostRequestDto createPostRequestDto){
//       PostService postService = new PostService();
       return postService.createPost(createPostRequestDto);

    }

    @GetMapping("/test")
    public String test(){
        System.out.print("테스트입니다");
        return "test";
    }
//    @GetMapping("/readPost")
//    public List<CreatePostResponseDto> getPost(){return postService.createPost();}
}


