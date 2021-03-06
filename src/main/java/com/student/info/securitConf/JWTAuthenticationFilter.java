package com.student.info.securitConf;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        System.out.println("--------------------------: 用户进入过滤器请求地址：" + request.getRequestURL() + ",请求方法：" + request.getMethod());

        if (header == null || !header.startsWith("Dragonsking ")) {
            System.out.println("--------------------------: 用户没有携带请求头~");
            // response.setHeader("X-Token", String.valueOf(ResultCode.UNAUTHORIZED));
            // SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("abel", null, new ArrayList<>()));
            chain.doFilter(request, response);
            return;
        }

//        boolean authentication = getAuthentication(request);
//
//        if (!authentication) {
//
//            logger.warn("JWTAuthenticationFilter.authentication 发生错误,验证没通过!");
//            response.setHeader("X-Token", String.valueOf(ResultCode.UNAUTHORIZED));
//
//        } else {
//            response.setHeader("X-Token", String.valueOf(ResultCode.SUCCESS));
//        }
        //response.setHeader("X-Token", String.valueOf(ResultCode.SUCCESS));
        //SecurityContextHolder.getContext().setAuthentication(authentication);

        //System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        chain.doFilter(request, response);

    }

    private boolean getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        if (token != null) {
            try {
                SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                        .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                // 登录名
                System.out.println("Username:"
                        + securityContextImpl.getAuthentication().getName());
                // 登录密码，未加密的
                System.out.println("Credentials:"
                        + securityContextImpl.getAuthentication().getCredentials());
                WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl
                        .getAuthentication().getDetails();
                // 获得访问地址
                // System.out.println("RemoteAddress" + details.getRemoteAddress());
                // 获得sessionid
                // System.out.println("SessionId" + details.getSessionId());
                // 获得当前用户所拥有的权限
                List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl
                        .getAuthentication().getAuthorities();
                for (GrantedAuthority grantedAuthority : authorities) {
                    System.out.println("Authority" + grantedAuthority.getAuthority());
                }

                System.out.println("当前已登录用户：" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
                String username = Jwts.parser()
                        .setSigningKey("MyJwtSecret")
                        .parseClaimsJws(token.replace("Dragonsking ", ""))
                        .getBody()
                        .getSubject();
                if (username != null) {
                    //return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                    String userDetails = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    if (userDetails.equals(username)) {
                        return true;
                    }
                    // parse the token.
                    return false;
                }
            } catch (Exception e) {
                System.out.println("JWTAuthenticationFilter.getAuthentication()方法验证身份错误，出现如下错误：" + e);
                return false;
            }

            return false;
        }
        return false;
    }
}

