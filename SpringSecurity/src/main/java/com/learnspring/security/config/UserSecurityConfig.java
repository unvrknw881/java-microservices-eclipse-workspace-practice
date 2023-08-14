package com.learnspring.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.learnspring.security.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class UserSecurityConfig {
	

//	credentials creation and authenticating
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails usr1 = User.builder().username("siva").password(pwdEncoder().encode("siva")).roles("ADMIN").build();
//		UserDetails usr2 = User.builder().username("nageshwar").password(pwdEncoder().encode("nageshwar")).roles("DEV").build();
//		return new InMemoryUserDetailsManager(usr1, usr2);
//	}



//	credentials creation and authenticating using custom user details and database
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new UserInfoUserDetailsService();
	}

	
	
	
//	Authorization
	
//	This is for lower spring boot version like <= 3.0.0
//	@Bean
//	public SecurityFilterChain roleAuthorization(HttpSecurity http) throws Exception {
//	   return	http.csrf().disable()
//			                 .authorizeHttpRequests().requestMatchers("/home/publicurl/**").permitAll()
//			                 .and()
//			                 .authorizeHttpRequests().requestMatchers("/**").authenticated()
//			                 .and().formLogin()
//			                 .and().build();
//	}
	
//	above spring boot version 3.0.0 we have to use this lambda and method references.
	@Bean
	public SecurityFilterChain roleAuthorization(HttpSecurity http) throws Exception {
		
	   	
			   //disable csrf using lamda function
//			   http.csrf(a->a.disable())
			   //disable csrf using Method reference
			   http.csrf(AbstractHttpConfigurer::disable)
//			                 .authorizeHttpRequests(auth-> auth.requestMatchers("/home/publicurl/**").permitAll())
			                 .authorizeHttpRequests(auth->auth.requestMatchers("/**").authenticated()).formLogin(withDefaults());                  
			                 
	   return http.build();
			                 
			                 
	}
	
	
	

	@Bean
	public PasswordEncoder pwdEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	
	
	
}
