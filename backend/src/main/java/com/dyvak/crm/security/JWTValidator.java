package com.dyvak.springbootvuejs.security;

import com.dyvak.springbootvuejs.exception.TokenNotPassValidationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JWTValidator {

    static final String SECRET_KEY = "youtube";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";


    public JWTUser validate(String token) {
        System.out.println(token);
        JWTUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = JWTUser.builder()
                    .email(body.getSubject())
                    .id(Long.parseLong((String) body.get("userId")))
                    .role(UserRole.valueOf((String) body.get("role")))
                    .build();
            System.out.println(jwtUser);

        } catch (Exception cause) {
            throw new TokenNotPassValidationException("Token not pass validation", cause);
        }
        return jwtUser;
    }
}
