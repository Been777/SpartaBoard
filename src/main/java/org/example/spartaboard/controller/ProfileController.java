package org.example.spartaboard.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaboard.dto.ProfileRequestDto;
import org.example.spartaboard.dto.ProfileResponseDto;
import org.example.spartaboard.entity.User;
import org.example.spartaboard.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class ProfileController {

    private final ProfileService profileService;

    //프로필 조회
    @GetMapping("")
    public ProfileResponseDto showProfile(ProfileRequestDto requestDto) {
        User user = new User();
        return profileService.showProfile(requestDto, user);

    }

}
