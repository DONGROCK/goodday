package com.ohg.security.config;

import com.ohg.security.common.UserRole;
import com.ohg.security.config.handler.AuthFailHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 세큐리티값쓸거야
public class SecurityConfig {

    private final AuthFailHandler authFailHandler;
    public SecurityConfig(AuthFailHandler authFailHandler) {
        this.authFailHandler = authFailHandler;
    }


    /*비밀번호 인코딩*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*정적인 리소스 설정 제외 처리*/
    //js, css, img 에 대한 내용

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //너 권한 뭐야?
        http.authorizeHttpRequests(auth -> { // 페이지 권한설정
            auth.requestMatchers("/auth/login", "/auth/fail", "/user/singup", "/user/member", "/").permitAll(); // 모든 리소스를 권한없이 사용가능하다. permitAll()

            auth.requestMatchers("admin/*").hasAnyAuthority(UserRole.ADMIN.getRole());
            auth.requestMatchers("user/*").hasAnyAuthority(UserRole.USER.getRole());

            auth.anyRequest().authenticated();
        })
                //로그인 설정
                .formLogin(login -> {
                    login.loginPage("/auth/login"); //로그인 요청 페이지
                    login.usernameParameter("username"); // 사용자 id 입력 필드 (input의 name과 일치)
                    login.passwordParameter("password"); //사용자 password 입력 필드(input의 password와 일치)

                    login.defaultSuccessUrl("/"); //로그인 성공ㅅ ㅣ이동할 페이지
                    login.failureHandler(authFailHandler);
                })
                    //로그아웃 설정
        .logout(logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")); //로그아웃 요청 url
            logout.deleteCookies("JSESSIONID"); // 로그아웃 시 사용자의 JSESSIONID 삭제
            logout.invalidateHttpSession(true); // 서버 세션 소멸처리
            logout.logoutSuccessUrl("/"); // 로그아웃 성공 시 이동할 페이지
        })
                //세션 설정
                .sessionManagement(session ->{
                    session.maximumSessions(1); //세션 갯수제한
                    session.invalidSessionUrl("/"); //세션 만료시 이동할 url
                })
                .csrf(csrf -> csrf.disable()); //

        return http.build();

    }
}
