package com.Mrs.Wang.project.securitConf;

import com.Mrs.Wang.project.DTO.RolesDTO;
import com.Mrs.Wang.project.DTO.TokenDTO;
import com.Mrs.Wang.project.core.Result;
import com.Mrs.Wang.project.core.ResultCode;
import com.Mrs.Wang.project.model.User;
import com.Mrs.Wang.project.service.UserService;
import com.Mrs.Wang.project.service.impl.UserServiceImpl;
import com.Mrs.Wang.project.utils.JWTUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @author zhaoxinguo on 2017/9/12.
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;


    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            User user = new User();
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
//            User user = new ObjectMapper()
//                    .readValue(req.getInputStream(), User.class);

            SecurityContextHolder.setStrategyName(MODE_INHERITABLETHREADLOCAL);
            System.out.println("Check Strategy: " + SecurityContextHolder.getContextHolderStrategy().toString());

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        UserService userService = new UserServiceImpl();

        String token = Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        res.addHeader("X-Token", "Dragonsking " + token);
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken("Dragonsking " + token);
        res.setStatus(200);
        Result result = new Result();
        result.setData(tokenDTO);
        result.setCode(ResultCode.SUCCESS).setMessage("登陆成功");
        res.setCharacterEncoding("UTF-8");
        res.setHeader("Content-type", "application/json;charset=UTF-8");
        res.getWriter().write(JSON.toJSONString(result));
        System.out.println("用户：" + ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername()
                + "登陆成功,Token：" + token);

        System.out.println("denglu：" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}