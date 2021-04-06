package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnUser;
import com.sparta.clonekurly.model.Users;
import com.sparta.clonekurly.repository.UserRepository;
import com.sparta.clonekurly.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/api/signup")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(Users.builder()
                .username(user.get("username"))
                .password(passwordEncoder.encode(user.get("password")))
                .name(user.get("name"))
                .build()).getId();
    }

    // 로그인
    @PostMapping("/api/login")
    public ReturnUser login(@RequestBody Map<String, String> user) {

        Users member = userRepository.findByUsername(user.get("username"))
                .orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수 없습니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        ReturnUser returnUser = new ReturnUser();
        returnUser.setToken(jwtTokenProvider.createToken(member.getUsername()));
        returnUser.setName(member.getName());
        return returnUser;
    }


}
