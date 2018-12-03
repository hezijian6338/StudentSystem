package com.Mrs.Wang.project.securitConf;


import com.Mrs.Wang.project.core.ResultCode;
import com.Mrs.Wang.project.dao.PermissionMapper;
import com.Mrs.Wang.project.dao.UserMapper;
import com.Mrs.Wang.project.model.Permission;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 *
 * @author zhaoxinguo on 2017/9/13.
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("X-Token");


        if (header == null || !header.startsWith("Dragonsking ")) {
            response.setHeader("X-Token", String.valueOf(ResultCode.UNAUTHORIZED));
            //SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("abel", null, new ArrayList<>()));
            chain.doFilter(request, response);
            return;
        }

        boolean authentication = getAuthentication(request);

        if(!authentication){
            response.setHeader("X-Token", String.valueOf(ResultCode.UNAUTHORIZED));
        }else {
            response.setHeader("X-Token", String.valueOf(ResultCode.SUCCESS));
        }

        //SecurityContextHolder.getContext().setAuthentication(authentication);

        //System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        chain.doFilter(request, response);

    }

    private boolean getAuthentication(HttpServletRequest request) {

        String token = request.getHeader("X-Token");
        if (token != null) {
            try {
                String username = Jwts.parser()
                        .setSigningKey("MyJwtSecret")
                        .parseClaimsJws(token.replace("Dragonsking ", ""))
                        .getBody()
                        .getSubject();
                if (username != null) {
                    //return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                    String userDetails =  (String) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
                    if(userDetails.equals(username)){
                        return true;
                    }
                    // parse the token.
                    return false;
                }
            }catch (Exception e){
                System.out.println(e);
                return false;
            }

            return false;
        }
        return false;
    }

}

