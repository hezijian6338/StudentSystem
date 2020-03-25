package com.student.info.DTO;

/**
 * @program: spring-boot-api-project-seed
 * @description: X-Token验证DTO
 * @author: hezijian6338
 * @create: 2018-11-29 09:56
 **/

public class TokenDTO {
    private String Token;

    public void setToken(String token) {
        Token = token;
    }

    public String getToken() {
        return Token;
    }
}
