package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnCheckId;
import com.sparta.clonekurly.controllerReturn.ReturnUser;
import com.sparta.clonekurly.model.Cart;
import com.sparta.clonekurly.model.User;
import com.sparta.clonekurly.repository.CartRepository;
import com.sparta.clonekurly.repository.UserRepository;
import com.sparta.clonekurly.security.JwtTokenProvider;
import com.sparta.clonekurly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserService userService;
    private final CartRepository cartRepository;

    // 회원가입
    @PostMapping("/api/signup")
    public Long join(@RequestBody Map<String, String> user) {
        User newUser = User.builder()
                        .username(user.get("username"))
                        .password(passwordEncoder.encode(user.get("password")))
                        .name(user.get("name")).build();
        Cart cart = new Cart(newUser);
        userRepository.save(newUser);
        cartRepository.save(cart);
        return newUser.getId();
    }

    // ID 중복 체크
    @PostMapping ("/api/signup/checkid")
    public ReturnCheckId checkId(@RequestBody Map<String, String> user){
        ReturnCheckId returnCheckId = new ReturnCheckId();
        Optional<User> member = userRepository.findByUsername(user.get("username"));
        if(member.isPresent()){
            returnCheckId.setOk(false);
            returnCheckId.setMsg("중복된 ID가 존재합니다.");
        } else{
            returnCheckId.setOk(true);
            returnCheckId.setMsg("사용 가능한 ID 입니다.");
        }
        return returnCheckId;
    }

    // 로그인
    @PostMapping("/api/login")
    public ReturnUser login(@RequestBody Map<String, String> user) {
            return userService.login(user);
    }

}
