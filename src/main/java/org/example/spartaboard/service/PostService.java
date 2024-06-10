package org.example.spartaboard.service;

import jakarta.transaction.Transactional;
import org.example.spartaboard.dto.CreatePostRequestDto;
import org.example.spartaboard.dto.CreatePostResponseDto;
import org.example.spartaboard.entity.Post;
import org.example.spartaboard.entity.User;
import org.example.spartaboard.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
    public String Userinfo(CreatePostResponseDto createPostResponseDto) {
        long userid = createPostResponseDto.getId();
        //  public void VaildationRefreshToken
        //     User userToken = postRepository.findById(userid);  유저 엔티티가있다고 가정 할 경우

        return null;
    }

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository; // 의존성 주입
    }

    @Transactional
    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto) {
        String content = createPostRequestDto.getContent();
        User userid = createPostRequestDto.getUserid();
        Post post = new Post(userid, content); //
        postRepository.save(post);
        return new CreatePostResponseDto(post);
    }


    public List<CreatePostResponseDto> getAllPosts() {
        return postRepository.findAll().stream().map(CreatePostResponseDto::new).toList();
    }
}
