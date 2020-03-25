package com.student.info.securitConf;

import com.student.info.model.Permission;
import com.student.info.service.PermissionService;
import com.student.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;

    public UserDetails loadUserByUsername(String username) {
        com.student.info.model.User user = userService.findByUserName(username);
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
