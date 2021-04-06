package com.sparta.clonekurly.jwt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

// 사용자에게 반환될 JWT를 담은 Response
@Getter
@RequiredArgsConstructor
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
}
