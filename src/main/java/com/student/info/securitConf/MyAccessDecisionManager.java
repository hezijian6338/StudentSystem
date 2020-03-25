package com.student.info.securitConf;

import com.student.info.core.ResultCode;
import com.student.info.model.Permission;
import com.student.info.service.PermissionService;
import com.student.info.service.UserService;
import com.student.info.utils.JWTUtils;
import com.student.info.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yangyibo on 17/1/19.
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;

    //decide 方法是判定是否拥有权限的决策方法
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        HttpServletResponse response = ((FilterInvocation) object).getResponse();

        /** 过滤权限的时候,对于有Token和不是preflight的请求通通重新获取权限信息,因为很大几率会在preflight中丢失记录*/
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(!request.getMethod().equals("OPTIONS") && request.getHeader("X-Token") != null) {
            String username = JWTUtils.getAuthentication(request.getHeader("X-Token"));
            try {
                User user = userService.findByUserName(username);
                List<Permission> permissions = permissionService.findByAdminUserId(user.getId());
                for (Permission permission : permissions) {
                    if (permission != null && permission.getName() != null) {

                        GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(), permission.getMethod());
                        grantedAuthorities.add(grantedAuthority);
                    }
                }
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),grantedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                response.setHeader("X-Token", String.valueOf(ResultCode.SUCCESS));
            }catch (NullPointerException e) {
                System.out.println("验证Token且重新获取权限的时候出现错误,错误是:" + e);
                logger.warn("验证出现错误: 重新获取权限步骤,出现{}错误!", e);
                response.setHeader("X-Token", String.valueOf(ResultCode.UNAUTHORIZED));
            }
        } else if (new AntPathRequestMatcher("/user/non/password").matches(request)) {
            response.setHeader("X-Token", String.valueOf(ResultCode.SUCCESS));
            return;
        } else if (request.getMethod().equals("OPTIONS")) {
            response.setHeader("X-Token", String.valueOf(ResultCode.UNAUTHORIZED));
            logger.warn("preflight request!");
            return;
        }


        String url, method;
        AntPathRequestMatcher matcher;
//        for (GrantedAuthority ga : authentication.getAuthorities()) {
        for (GrantedAuthority ga : grantedAuthorities) {
            if (ga instanceof MyGrantedAuthority) {
                MyGrantedAuthority urlGrantedAuthority = (MyGrantedAuthority) ga;
                url = urlGrantedAuthority.getPermissionUrl();
                method = urlGrantedAuthority.getMethod();
                matcher = new AntPathRequestMatcher(url);
                if (matcher.matches(request)) {
                    //当权限表权限的method为ALL时表示拥有此路径的所有请求方式权利。
                    if (method.equals(request.getMethod()) || "ALL".equals(method)) {
                        return;
                    }
                }
            } else if (ga.getAuthority().equals("ROLE_ANONYMOUS")) {//未登录只允许访问 login 页面
                matcher = new AntPathRequestMatcher("/user/non/password");
                if (matcher.matches(request)) {
                    return;
                }
            }
        }
        String token = response.getHeader("X-Token");
        boolean pass = token.equals(String.valueOf(ResultCode.SUCCESS));
        if (!pass)
            throw new AccessDeniedException("no right");
        else
            return;
    }



    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
