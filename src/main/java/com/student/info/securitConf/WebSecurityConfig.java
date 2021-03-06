package com.student.info.securitConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by yangyibo on 17/1/18.
 */


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Autowired
    UserDetailsService CustomUserService;

//    @Bean
//    UserDetailsService customUserService() { //注册UserDetailsService 的bean
//        return new CustomUserService();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(CustomUserService); //user Details Service验证
        auth.eraseCredentials(false);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .headers()
//                .frameOptions()
//                .sameOrigin()
//                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/non/password").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated() //任何请求,登录后可以访问
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .permitAll() //登录页面用户任意访问
//                .and()
//                .logout().permitAll()
                //注销行为任意访问
                .and()
                .csrf().disable()
                //.cors()
                //.and()
                .httpBasic().disable()
                // ReST is stateless, no sessions
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //
                ;

        http
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }
}

