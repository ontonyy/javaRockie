package com.justony.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
//	@Autowired
//	private DataSource dataSource;
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//				.authorizeHttpRequests((requests) -> requests
//						.antMatchers("/", "/home").permitAll()
//						.antMatchers("/user/**").hasRole("USER")
//				)
//			.formLogin((login) -> login
//				.loginPage("/login")
//					.failureUrl("/login?error")
//						.permitAll()
//			)
//			.logout()
//				.logoutSuccessUrl("/login?logout")
//					.permitAll();
//
//		return http.build();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		String usersByUsernameQuery = "select username, password, active from users where username = ?";
//		String authsByUserQuery = "select username, roles from users u inner join user_role ur on id = user_id where username=?";
//
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.passwordEncoder(passwordEncoder())
//				.usersByUsernameQuery(usersByUsernameQuery)
//				.authoritiesByUsernameQuery(authsByUserQuery);
//	}
//
//
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
