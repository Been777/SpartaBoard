package org.example.spartaboard.service;

import org.example.spartaboard.dto.CreatePostRequestDto;
import org.example.spartaboard.dto.CreatePostResponseDto;
import org.example.spartaboard.entity.Post;
import org.example.spartaboard.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {


    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository; // 의존성 주입
    }

    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto) {
        Post post = new Post(createPostRequestDto);
        postRepository.save(post);
        return new CreatePostResponseDto(post);
    }

    public List<CreatePostResponseDto> getAllPosts() {
        return postRepository.findAll().stream().map(CreatePostResponseDto::new).toList();
    }
}
