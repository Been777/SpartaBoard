package org.example.spartaboard.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaboard.dto.ProfileModifyRequestDto;
import org.example.spartaboard.dto.ProfileRequestDto;
import org.example.spartaboard.dto.ProfileResponseDto;
import org.example.spartaboard.entity.User;
import org.example.spartaboard.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class ProfileController {

    private final ProfileService profileService;

    //프로필 조회
    @GetMapping("")
    public ResponseEntity<ProfileResponseDto> showProfile(ProfileRequestDto requestDto) {
        return profileService.showProfile(requestDto);
    }

    //프로필 수정 //mock up (UserDetails 대신 user)
    @PatchMapping("/update")
    public ResponseEntity<ProfileResponseDto> updateProfile(ProfileModifyRequestDto modifyRequestDto) {
        User user = new User();
        // 비밀번호 형식은 user 정보에서 설정
        //pwRequestDto 가 채워져 있을 경우 검증 거치기 (기존 비밀번호 확인 / 입력받아야 함)
        //비워져 있으면 그냥 Service 의 메서드로 보내기
        return profileService.updateProfile(modifyRequestDto, user);
    }

    private boolean authorizePassword(String newPassword) {
        return false;
    }


}
