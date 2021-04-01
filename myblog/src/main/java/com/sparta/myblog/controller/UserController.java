package com.sparta.myblog.controller;

import com.sparta.myblog.dto.SignupRequestDto;
import com.sparta.myblog.model.User;
import com.sparta.myblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 페이지 내려주기
    @GetMapping("/user/login")
    public String login() {
        log.info("로그인 하는 페이지");
        return "login";
    }


    // 로그인 에러 -> 데이터 쏴주기
    // 실패 url이 선택이 안되는데
    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        log.info("사실 로그인 실패한 것");
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        log.info("회원가입 성공!");
        return "login";     // 왜 login으로 안가고 signup으로 가지?
    }





    // 안됨... -> 이렇게 하는 거 아니야
    @PostMapping("/user/signup/usernameCheck")
    public String duplicationCheck(@RequestBody String username, Model model) {
        System.out.println("중복 확인 요청 username: " + username);

//        Map<String, Object> data = new HashMap<>();

        boolean result = userService.isDuplicateUsername(username);

        if (result) {
            System.out.println("아이디 중복");
            model.addAttribute("fail", "중복된 username 입니다.");
            return "signup";
//            data.put("confirm", "Fail");
        } else {
            System.out.println("아이디 사용 가능");
            model.addAttribute("success", "사용 가능한 username 입니다.");
            return "signup";
//            data.put("confirm", "Success");
        }

    }
}
