package org.example.spartaboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.spartaboard.Security.UserDetailsImpl;
import org.example.spartaboard.dto.UserRequestDto2;
import org.example.spartaboard.entity.User;
import org.example.spartaboard.service.UserService2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController2 {

    private final UserService2 userService;

    //회원 가입

    //주의. 로그인은 filter 에서 처리함
    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request,
                                         @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User loginUser = userDetails.getUser();
        return userService.logout(request, loginUser);
    }


    //회원 탈퇴
    @PutMapping("/delete")
    public ResponseEntity<String> deleteUser (@RequestBody UserRequestDto2 RequestDto,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User loginUser = userDetails.getUser();
        return userService.deleteUser(RequestDto, loginUser);
    }



}
