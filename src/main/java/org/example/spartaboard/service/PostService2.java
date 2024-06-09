package org.example.spartaboard.service;

import lombok.RequiredArgsConstructor;
import org.example.spartaboard.dto.PostResponseDto2;
import org.example.spartaboard.entity.Post2;
import org.example.spartaboard.entity.UserStatus;
import org.example.spartaboard.repository.PostRepository2;
import org.example.spartaboard.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService2 {

    private final PostRepository2 postRepository;
    private final UserRepository userRepository;

    // 로그인 인증한 사람이 모든 사용자의 전체 게시글 시간순 조회
    public ResponseEntity<List<PostResponseDto2>> showPost(Long loginUserId) {

        //사용자가 ACTIVE 상태인지 확인하는 절차
        boolean activeLoginUser = userRepository.existsUserByIdAndStatus(loginUserId, UserStatus.ACTIVE);
        if (!activeLoginUser) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        //게시글이 ACTIVE 사용자 것이 아니어도 되는지 확인하는 메서드 - 필요 없나? (= 탈퇴한 사용자가 올린 글도 조회가능?)

        //모든 게시글을 찾아서 최신순(생성일자 기준 내림차순) 정렬
        List<Post2> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC,"CreatedAt"))
                .stream().toList();

        // 게시글 없는 경우 = 회원들 중 단 한명도 글을 안 올린 경우를 말하는 건가?//나중에 구독기능이라도 넣으면 가능한 설정인 듯?
        if (posts.isEmpty()) {
            ResponseEntity.status(HttpStatus.OK).body("먼저 작성하여 소식을 알려보세요!");
        }

        //페이징 처리(추가구현)


        //찾은 List 를 Dto 타입으로 변환
        List<PostResponseDto2> allPost = new ArrayList<>();
        for (Post2 post : posts) {
            allPost.add(new PostResponseDto2(post));
        }
        //Entity 에 담아서 return
        return ResponseEntity.ok(allPost);
    }
}
