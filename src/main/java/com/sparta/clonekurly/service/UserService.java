package com.sparta.clonekurly.service;

import com.sparta.clonekurly.controllerReturn.ReturnUser;
import com.sparta.clonekurly.model.User;
import com.sparta.clonekurly.repository.UserRepository;
import com.sparta.clonekurly.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public ReturnUser login(Map<String, String> user) {
        ReturnUser returnUser = new ReturnUser();
        try {
            User member = userRepository.findByUsername(user.get("username"))
                    .orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수 없습니다."));
            if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
                throw new IllegalArgumentException("잘못된 비밀번호입니다.");
            }
            returnUser.setToken(jwtTokenProvider.createToken(member.getUsername()));
            returnUser.setName(member.getName());
            return returnUser;
        } catch (IllegalArgumentException e) {
            returnUser.setMsg(e.getMessage());
            return returnUser;
        }
    }
}
