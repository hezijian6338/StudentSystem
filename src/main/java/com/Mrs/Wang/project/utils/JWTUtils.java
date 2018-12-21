package com.Mrs.Wang.project.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @program: spring-boot-api-project-seed
 * @description: 用于解析JWT
 * @author: hezijian6338
 * @create: 2018-11-30 15:02
 **/

public class JWTUtils {
    public static String getAuthentication(String token) {
        //String token = request.getHeader("X-Token");
        if (token != null) {
            try {
                String username = Jwts.parser()
                        .setSigningKey("MyJwtSecret")
                        .parseClaimsJws(token.replace("Dragonsking ", ""))
                        .getBody()
                        .getSubject();
                if (username != null) {
                    // parse the token.
                    return username;
                }
            }catch (Exception e){
                System.out.println(e);
                return null;
            }
            return null;
        }
        return null;
    }

    public static String setAuthentication(String password) {
        String token = Jwts.builder()
                .setSubject(password)
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        return token;
    }
}
