package org.example.spartaboard.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.spartaboard.dto.ProfileRequestDto;
import org.example.spartaboard.dto.ProfileResponseDto;
import org.example.spartaboard.entity.User;
import org.example.spartaboard.entity.UserStatus;
import org.example.spartaboard.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService {

    private final UserRepository userRepository;

    //프로필 조회 //UserDetails 사용 전 까지 User 로 mock up
    public ResponseEntity<ProfileResponseDto> showProfile(ProfileRequestDto requestDto, User user) {

        //requestDto 의 UserId 와 password 로 DB 에서 일치하는 (조회할) 유저 찾기
        String requestUserId = requestDto.getUserId();
        String requestPassword = requestDto.getPassword();
        User requestUser = userRepository.findByUserIdAndPassword(requestUserId, requestPassword)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"잘못된 접근입니다.")
        );

        //회원탈퇴시 상태만 변경하기 때문에 확인 거치는게 맞으나, 요구사항에 없기때문에 하지 않아도 되긴 함
        //Request 의 user 가 탈퇴(DEACTIVATED) 인지 아닌지(ACTIVE) 확인
        boolean activeUser = userRepository.existsUserByUserIdAndStatus(requestUserId, UserStatus.ACTIVE);
        if (!activeUser) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        //조회 요청 들어온 user 와 로그인한 user 가 동일한지 확인
        if (!requestUserId.equals(user.getUserId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(new ProfileResponseDto(requestUser));
    }
}
