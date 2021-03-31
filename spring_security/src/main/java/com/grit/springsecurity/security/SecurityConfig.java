package com.grit.springsecurity.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;    // 모든 파라미터가 다 필요한가?

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

//        String password = passwordEncoder().encode("1111");
//
//        auth.inMemoryAuthentication().withUser("user").password(password).roles("USER");
//        auth.inMemoryAuthentication().withUser("manager").password(password).roles("MANAGER");
//        auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMIN");

        // 얘는 왜.. 자기 자신을 자기한테 넣는 거지?
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf 비활성화
        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.csrf().disable();
        // x-frame 비활성화, h2는 iframe 사용
        http.headers().frameOptions().disable();

        http
                .authorizeRequests()
                .antMatchers("/", "/loginUser").permitAll()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/manager").hasRole("MANAGER")
                .antMatchers("/admin").hasRole("ADMIN")

                .antMatchers("/h2-console/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/test")
                .permitAll();
    }
}


