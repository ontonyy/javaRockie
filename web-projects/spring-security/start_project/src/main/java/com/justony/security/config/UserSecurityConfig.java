package com.justony.security.config;

import com.justony.security.details.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@Order(2)
public class UserSecurityConfig {
    @Autowired private DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/user/register").permitAll()
                .and()
                    .antMatcher("/user/**")
                    .authorizeRequests()
                    .anyRequest().hasAuthority("USER")
                .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .usernameParameter("username")
                    .failureUrl("/user/login?error=error")
                    .loginProcessingUrl("/user/login")
                    .defaultSuccessUrl("/user/main", true)
                    .permitAll()
                .and()
                    .logout().logoutUrl("/user/logout")
                    .logoutSuccessUrl("/user/login?logout=logout")
                    .permitAll();
        return http.build();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        String usersByUsernameQuery = "select username, password, active from users where username = ?";
//        String authsByUserQuery = "select username, roles from users u inner join user_role ur on id = user_id where username=?";
//
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery(usersByUsernameQuery)
//                .authoritiesByUsernameQuery(authsByUserQuery);
//    }
//
//
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
