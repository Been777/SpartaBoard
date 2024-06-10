package org.example.spartaboard.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaboard.Security.UserDetailsImpl;
import org.example.spartaboard.dto.CommentRequestDto;
import org.example.spartaboard.dto.CommentResponseDto;
import org.example.spartaboard.entity.Comment;
import org.example.spartaboard.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class CommentController {
    private final CommentService commentService;



    @PostMapping("/{postid}/comment")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long postid,
            @RequestBody CommentRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        CommentResponseDto createDto = commentService.createComment(postid, requestDto,
                userDetails.getUser());

        return ResponseEntity.ok().body(createDto);
    }

    @PutMapping("/{postid}/comment/{commentid}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable("postid") Long postid,
            @PathVariable("commentid") Long commentid,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        Comment comment = commentService.updateComment(postid, commentRequestDto, userDetails.getUser());
        return new ResponseEntity<>(new CommentResponseDto(comment), HttpStatus.OK);
    }

    @DeleteMapping("/{postid}/comment/{commentid}")
    public ResponseEntity<String> deleteComment(
            @PathVariable("postid") Long postId,
            @PathVariable("commentid") Long commentid,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        commentService.deleteComment(commentid, userDetails.getUser());
        return ResponseEntity.ok("댓글 삭제 완료");
    }

}
