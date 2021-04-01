package com.sparta.myblog.controller;


import com.sparta.myblog.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

//    @GetMapping("/member")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        model.addAttribute("username", userDetails.getUsername());
//        log.info("username은 "+ userDetails.getUsername() );
//        return "redirect:/";
//    }

    // 모든 사용자에게
    @GetMapping("/")
    public String home(Model model) {
        log.info("모든 사용자 페이지");
        return "index";
    }

//    @GetMapping("/welcome")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        model.addAttribute("username", userDetails.getUsername());
//        System.out.println("로그인 하면 볼 수 있는 페이지");
//        return "test";

}