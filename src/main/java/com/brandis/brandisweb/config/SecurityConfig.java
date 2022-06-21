package com.brandis.brandisweb.config;

import com.brandis.brandisweb.service.BUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private BCryptPasswordEncoder cryptPasswordEncoder;
    private BUserService bUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/css/**",
                        "/js/**",
                        "/sign-in/**",
                        "/h2-console/**",
                        "/register/**",
                        "/register/",
                        "/static/**",
                        "/static/static/**",
                        "/static/static/css",
                        "/static/static/js",
                        "/static/static/media",
                        "/get-company-name/",
                        "/",
                        "/get-bgame/",
                        "/login",
                        "/module-login/",
                        "/create-new-game/",
                        "/module-logout/",
                        "/webjars/**",
                        "/move-funds/**"
                        ,"/move-funds/"
                        ,"/transfer-funds/**"
                        ,"/transfer-funds/")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**", "/register/**", "/move-funds/", "/move-funds/**" +
                        "/transfer-funds/**","/transfer-funds/",",/register/","/target/classes/static/**", "/", "/get-bgame/", "/module-login/","/create-new-game/", "/module-logout/")
                .and()
                .headers().frameOptions().disable()
                .and()
                .cors()
                .disable();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(bUserService).passwordEncoder(cryptPasswordEncoder);
    }
}
