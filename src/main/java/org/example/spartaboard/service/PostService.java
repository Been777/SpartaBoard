package org.example.spartaboard.service;

import org.example.spartaboard.dto.CreatePostRequestDto;
import org.example.spartaboard.dto.CreatePostResponseDto;
import org.example.spartaboard.entity.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.example.spartaboard.repository.PostRepository;

import java.util.List;

@Service
@Component

public class PostService {


private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto) {
        Post post = new Post(createPostRequestDto);

        Post savedPost = postRepository.save(post);

        return new CreatePostResponseDto(post);
    }

    public List<CreatePostResponseDto> getAllPosts() {
        return postRepository.findAll().stream().map(CreatePostResponseDto::new).toList();
    }
}
