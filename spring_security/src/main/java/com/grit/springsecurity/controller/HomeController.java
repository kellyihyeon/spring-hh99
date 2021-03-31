package com.grit.springsecurity.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        log.info("/ get mapping");
        return "home";
    }

    @GetMapping("/user")
    public String ConUser(Model model) {
        log.info("/user get mapping");
        return "/user/user";
    }

    @GetMapping("/manager")
    public String ConManager(Model model) {
        log.info("/manager get mapping");
        return "/user/manager";
    }

    @GetMapping("/admin")
    public String ConAdmin(Model model) {
        log.info("/admin get mapping");
        return "/user/admin";
    }


    @GetMapping("/test")
    public String test(Model model) {
        log.info("/test get mapping");
        return "/user/test";
    }
}
