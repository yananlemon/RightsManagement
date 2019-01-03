package site.ilemon.rightsmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import site.ilemon.rightsmanagement.service.IUserService;
import site.ilemon.rightsmanagement.service.impl.AppUserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private IUserService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .authorizeRequests()
	      	.antMatchers("/user/*").authenticated()
	      	.antMatchers("/index").authenticated()
	      	.antMatchers("/role/*").authenticated()
	      	.antMatchers("/permission/*").authenticated()
	      	.antMatchers("/login","/css/**","/js/**","/fonts/**","/images/**","/image/*").permitAll()
	      .and()
	      .formLogin()
	      	.defaultSuccessUrl("/index")
	        .loginPage("/login")
	        .failureUrl("/login?error=true");
	}

	@Bean
	UserDetailsService appUserDetailsService(){
		return new AppUserServiceImpl();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
		
	}
}
