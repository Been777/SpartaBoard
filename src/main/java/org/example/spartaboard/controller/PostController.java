package org.example.spartaboard.controller;

import org.example.spartaboard.dto.CreatePostRequestDto;
import org.example.spartaboard.dto.CreatePostResponseDto;
import org.example.spartaboard.entity.Post;
import org.example.spartaboard.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto){

       return postService.createPost(createPostRequestDto);

    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/readPost")
    public List<CreatePostResponseDto> getAllPosts(){

        return postService.getAllPosts();}
}


