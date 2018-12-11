package com.Mrs.Wang.project.securitConf;

import com.Mrs.Wang.project.dao.PermissionMapper;
import com.Mrs.Wang.project.dao.UserMapper;
import com.Mrs.Wang.project.model.Permission;
import com.Mrs.Wang.project.service.PermissionService;
import com.Mrs.Wang.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.core.context.SecurityContextHolder.MODE_GLOBAL;
import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;


@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;

    public UserDetails loadUserByUsername(String username) {
        com.Mrs.Wang.project.model.User user = userService.findByUserName(username);
        if (user != null) {
            List<Permission> permissions = permissionService.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {

                    GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }

            UsernamePasswordAuthenticationToken user1 = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(user1);

            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
