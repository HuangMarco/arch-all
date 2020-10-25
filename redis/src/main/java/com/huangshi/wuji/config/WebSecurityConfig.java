package com.huangshi.wuji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @EnableWebSecurity用来配置SB，以便于应用Spring Security 的web security support
     * 同时用来集成Spring MVC
     * WebSecurityConfigurerAdapter用来提供一些待覆盖的方法，这些方法被用来设置一些web security 的特殊属性的配置项
     * 更多：https://spring.io/guides/gs/securing-web/#initial
     *      https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-security
     */


    /**
     * configure方法用来表示哪个URL请求路径需要被安全校验，哪些不需要
     * 在本例中，凡是请求/以及/home的请求，都不需要被安全校验
     * 所有非上面2个路径的请求，都需要进行安全校验
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }

//    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
