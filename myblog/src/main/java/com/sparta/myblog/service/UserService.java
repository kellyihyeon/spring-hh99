package com.sparta.myblog.service;

import com.sparta.myblog.dto.SignupRequestDto;
import com.sparta.myblog.model.User;
import com.sparta.myblog.model.UserRole;
import com.sparta.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    // 멤버 변수로 선언하면 다 이렇게 Autowired해서 생성자에 다 넣어줘야 하는 거야???
    // 안하니까 계속 빨간 줄 안없어지는데데
   @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // 나중에 테스트 때 리턴타입 필요하니까 넣어줌.
    public User registerUser(SignupRequestDto requestDto) {     // form으로 넘겨준 거
        String username= requestDto.getUsername();
//        String password = requestDto.getPassword();

        // username 중복확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {    // 값이 있으면 true, 없으면 false
            throw new IllegalArgumentException("중복된 닉네임 입니다.");
            // 프론트에 에러메시지 뿌리기.
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

        return user;
    }


    public boolean isDuplicateUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}

