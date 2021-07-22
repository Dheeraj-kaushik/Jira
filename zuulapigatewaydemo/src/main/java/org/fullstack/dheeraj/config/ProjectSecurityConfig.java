//package org.fullstack.dheeraj.config;
//
//import java.util.Collections;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.fullstack.dheeraj.filter.JWTTokenGeneratorFilter;
//import org.fullstack.dheeraj.filter.JWTTokenValidatorFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//@Configuration
//public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		//DEFAULT IMPLEMENTATION
//		
////		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
////		http.formLogin();
////		http.httpBasic();
//		
//		
//		//CUSTOMISED REQUIREMENT ALLOW 4 DENY 2
//		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
//		cors().configurationSource(new CorsConfigurationSource() {
//			@Override
//			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//				CorsConfiguration config = new CorsConfiguration();
//				config.setAllowedOrigins(Collections.singletonList("hhtp://localhost:4200"));
//				config.setAllowedMethods(Collections.singletonList("*"));
//				config.setAllowCredentials(true);
//				config.setAllowedHeaders(Collections.singletonList("*"));
//				config.setMaxAge(3600L);
//				return config;
//			}			
//		}).and().csrf().disable()
//		.addFilterBefore(new JWTTokenGeneratorFilter() , BasicAuthenticationFilter.class)
//		.addFilterAfter(new JWTTokenValidatorFilter() , BasicAuthenticationFilter.class)
//		.authorizeRequests(
//			(requests) -> requests
//			.antMatchers("/company").hasRole("USER")
//			.antMatchers("/project").hasAnyRole("USER" , "ADMIN")
//			.antMatchers("task").hasRole("ROOT")
//			.antMatchers("subtask").authenticated()
//				);	
//		http.formLogin();
//		http.httpBasic();
//		
//		
//		//DENY ALL REQUESTS
////		http.authorizeRequests((requests) -> requests.anyRequest().denyAll());
////		http.formLogin();
////		http.httpBasic();
//		
//		
//		//PERMIT ALL REQUESTS
//		http.authorizeRequests((requests) -> requests.anyRequest().permitAll());
//		http.formLogin();
//		http.httpBasic();
//	}
//	
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		
////		auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin").and()
////		.withUser("user").password("12345").authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
////	}
//	
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		
////		InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();
////		UserDetails user1 = User.withUsername("admin").password("12345").authorities("admin").build();
////		UserDetails user2 = User.withUsername("user").password("12345").authorities("read").build();
////		userDetailService.createUser(user1);
////		userDetailService.createUser(user2);
////		auth.userDetailsService(userDetailService);
////	}
//	
////	@Bean
////	public UserDetailsService userDetailsService (DataSource dataSource) {
////		return new JdbcUserDetailsManager(dataSource);
////	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
