package com.Mrs.Wang.project.securitConf;


import com.Mrs.Wang.project.dao.PermissionMapper;
import com.Mrs.Wang.project.dao.UserMapper;
import com.Mrs.Wang.project.model.Permission;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Resource
    UserMapper userMapper;
    @Resource
    PermissionMapper permissionMapper;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("X-Token");

        if (header == null || !header.startsWith("Dragonsking ")) {
            chain.doFilter(request, response);
            return;
        }

        //UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        //SecurityContextHolder.getContext().setAuthentication(authentication);


        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        System.out.println(userDetails.getUsername());


        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey("MyJwtSecret")
                    .parseClaimsJws(token.replace("Dragonsking ", ""))
                    .getBody()
                    .getSubject();

            if (username != null) {
                CustomUserService customUserService = new CustomUserService();
                return (UsernamePasswordAuthenticationToken) customUserService.loadUserByUsername(username);
//                com.Mrs.Wang.project.model.User user = userMapper.findByUserName(username);
//                if (user != null) {
//                    List<Permission> permissions = permissionMapper.findByAdminUserId(user.getId());
//                    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//                    for (Permission permission : permissions) {
//                        if (permission != null && permission.getName() != null) {
//
//                            GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
//                            grantedAuthorities.add(grantedAuthority);
//                        }
//                    }
//                    return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), grantedAuthorities);
//                }
//                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

}

