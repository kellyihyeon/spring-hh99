package com.grit.springsecurity.controller;

import com.grit.springsecurity.dto.AccountForm;
import com.grit.springsecurity.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @GetMapping("/loginUser")
    public String CreateUserForm(Model model) {
        model.addAttribute("userForm", new AccountForm());  // dto 전달
        return "user/login/register";
    }

    @PostMapping("/loginUser")      // 회원 가입 처리
    public String CreateUser(@Valid AccountForm accountForm, BindingResult result) {
        if (result.hasErrors()) {
            return "user/login/register";
        }
        accountService.createUser(accountForm);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }
}
