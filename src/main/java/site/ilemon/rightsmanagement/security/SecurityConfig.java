package site.ilemon.rightsmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import site.ilemon.rightsmanagement.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private IUserService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .authorizeRequests()
	      	.antMatchers("/user/users").authenticated()
	      	.antMatchers("/login","/css/**","/js/**","/fonts/**","/images/**","/image/*").permitAll()
	      .and()
	      .formLogin()
	        .loginPage("/login")
	        .failureUrl("/login?error=true");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserDetails userDetails =service.getUserByName(username);
				if (userDetails != null) {
		            return userDetails;
				}
				throw new UsernameNotFoundException("User '" + username + "' not found.");
			}
		}).passwordEncoder(new BCryptPasswordEncoder());
	}
}
