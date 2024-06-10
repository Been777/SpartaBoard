package org.example.spartaboard.controller;

import lombok.RequiredArgsConstructor;
import org.example.spartaboard.dto.ProfileModifyRequestDto;
import org.example.spartaboard.dto.ProfileRequestDto;
import org.example.spartaboard.dto.ProfileResponseDto;
import org.example.spartaboard.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<ProfileResponseDto> getProfile(@RequestParam String userid) {
        ProfileRequestDto requestDto = new ProfileRequestDto(userid);
        return profileService.showProfile(requestDto);
    }

    @PutMapping
    public ResponseEntity<ProfileResponseDto> updateProfile(@RequestBody ProfileModifyRequestDto modifyRequestDto) {
        return profileService.updateProfile(modifyRequestDto);
    }
}