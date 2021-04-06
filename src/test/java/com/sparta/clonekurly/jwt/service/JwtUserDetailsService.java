package com.sparta.clonekurly.jwt.service;

import com.sparta.clonekurly.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// DB에서 UserDetail를 얻어와 AuthenticationManager에게 제공하는 역할
// 이번에는 DB 없이 하드코딩된 User List에서 get userDetail

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Test
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        com.sparta.clonekurly.model.User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)
        );

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

//    Spring Security 5.0에서는 Password를 BcryptEncoder를 통해 Bcrypt화한다.
//        https://www.javainuse.com/onlineBcrypt 에서 user_pw를 Bcrypt화
//            2a$10m/enYHaLsCwH2dKMUAtQp.ksGOA6lq7Fd2pnMb4L.yT4GyeAPRPyS
//    id : user_id, pw: user_pw로 고정해 사용자 확인
//    사용자 확인 실패시 throw Exception
}
