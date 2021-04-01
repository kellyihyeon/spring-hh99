package com.sparta.myblog.service;

import com.sparta.myblog.dto.SignupRequestDto;
import com.sparta.myblog.model.User;
import com.sparta.myblog.model.UserRole;
import com.sparta.myblog.repository.UserRepository;
import com.sparta.myblog.security.UserDetailsImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@Transactional
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    // 멤버 변수로 선언하면 다 이렇게 Autowired해서 생성자에 다 넣어줘야 하는 거야???
    // @RequiredArgsConstructor달면 안되나..?
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // 나중에 테스트 때 리턴타입 필요하니까 넣어줌. -> (없앰)
    @Transactional
    public void registerUser(SignupRequestDto requestDto) {     // form에서 넘겨준 거
        String username = requestDto.getUsername();
//        String password = requestDto.getPassword();

        // username 중복확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {    // 값이 있으면 true, 없으면 false
            throw new IllegalArgumentException("중복된 닉네임 입니다.");
        }

        // password 인코딩
        String password = passwordEncoder.encode(requestDto.getPassword());
        // user role 확인
        UserRole role = UserRole.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRole.ADMIN;
        }


        User user = new User(username, password, role);
        userRepository.save(user);
        log.info("저장된 user: ", user);

//        return user;
    }


    // 강제 로그인 처리
//    UserDetailsImpl userDetails = new UserDetailsImpl(kakaoUser);
//    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    SecurityContextHolder.getContext().setAuthentication(authentication);

    // 필요없는 거
    public boolean isDuplicateUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}

