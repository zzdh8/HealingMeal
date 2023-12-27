package gsc.healingmeal.member.controller;

import gsc.healingmeal.member.domain.User;
import gsc.healingmeal.member.dto.LoginRequestDto;
import gsc.healingmeal.member.dto.SessionConst;
import gsc.healingmeal.member.dto.SessionDto;
import gsc.healingmeal.member.service.UserLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService){
        this.userLoginService = userLoginService;
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> memberLogin(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request){
        SessionDto sessionDto = userLoginService.login(loginRequestDto.getLoginId(), loginRequestDto.getPassword());
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(SessionConst.LOGIN_MEMBER, sessionDto);
        httpSession.setMaxInactiveInterval(1800);
        return new ResponseEntity<>(sessionDto.getLoginId().toString()+"님이 로그인하셨습니다.", HttpStatus.OK);
    }

    @GetMapping("/user/logout")
    public ResponseEntity<String> memberLogout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return new ResponseEntity<>("로그아웃 되었습니다.", HttpStatus.OK);
    }
}
