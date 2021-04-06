package com.sparta.clonekurly.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// JWT를 생성하고 검증하는 역할 수행
// io.jsonwebtoken.Jwts 라이브러리 사용
@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    @Value("${jwt.secret}")
    private String secret;

    // JWT token에서 username을 찾는다
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    // JWT token에서 만료 일자를 가져온다.
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // token에서 정보를 가져오기 위해서는 secret key가 필요함
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // token이 만료되었는지 체크
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // User를 위한 token을 만들어 낸다.
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    // token을 만들어내는 과정
    // 1. 권리(주장)를 정의하다?(발행인, 만료, 주제, ID 등?)
    // 2. HS512 알고리즘과 secret key를 이용해 JWT를  sign한다.
    // 3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String,Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                //.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    //    doGenerateToken
    //      Token 생성
    //      claim : Token에 담을 정보
    //      issuer : Token 발급자
    //      subject : Token 제목
    //      issuedate : Token 발급 시간
    //      expiration : Token 만료 시간
    //          milliseconds 기준!
    //          JWT_TOKEN_VALIDITY = 5 60 60 => 5시간
    //    signWith (알고리즘, 비밀키)

    // token 인증
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
