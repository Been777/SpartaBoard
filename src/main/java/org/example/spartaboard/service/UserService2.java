package org.example.spartaboard.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.spartaboard.dto.UserRequestDto2;
import org.example.spartaboard.entity.User;
import org.example.spartaboard.entity.UserStatus;
import org.example.spartaboard.jwt.JwtUtil;
import org.example.spartaboard.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService2 {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    //탈퇴한 사용자 ID는 재사용할 수 없습니다 -> 회원가입시 설정
    //회원상태로 탈퇴회원인지 아닌지 갈리기 때문에, user 기록은 남아있으니, ID 중복체크하면 재사용 안 될 것
    //탈퇴한 사용자 ID는 복구할 수 없습니다


    //로그아웃
    public ResponseEntity<String> logout(HttpServletRequest request, User loginUser) {
        String token = jwtUtil.invalidateToken();

        //access token 과 refresh token 초기화 - 재사용 불가(로그인 시 따로 발행)

        return null;
    }


    //회원 탈퇴
    @Transactional
    public ResponseEntity<String> deleteUser(UserRequestDto2 requestDto, User loginUser) {
        Long loginId = loginUser.getId(); //이걸 사용할 필요성에 대해 >> ACTIVE 확인할 때.. 메서드 공유때문
        String loginUserPW = loginUser.getPassword();
        String loginUserId = loginUser.getUserId();
        String requestPW = requestDto.getPassword();
        String requestUserId = requestDto.getUserId();

        // login 유저가 ACTIVE 상태인지 확인 -> INACTIVE 상태라면 "잘못된 접근입니다"
        boolean activeLoginUser = userRepository.existsUserByIdAndStatus(loginId, UserStatus.ACTIVE);
        if (!activeLoginUser) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("잘못된 접근입니다.");
        }

        //로그아웃시키기..를 만들지 않을 거면 모든 메서드에서 ACTIVE 인지 INACTIVE 인지 확인하는 메서드가 필요함/ 이라고 생각함

        // 확인용(requestDto)의 비밀번호/UserId가 loginUser 의 비밀번호/UserId와 불일치 -> Exception
        if (!requestPW.equals(loginUserPW) || !requestUserId.equals(loginUserId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("잘못된 접근입니다.");
        }

        // 상태변경
        loginUser.changeStatus();



        return ResponseEntity.ok("탈퇴되었습니다.");
    }
}

