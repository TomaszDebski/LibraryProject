package com.library.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * @author Tomasz Dębski
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@PropertySource("classpath:application.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	Environment env;
	
	@Autowired
	DataSource dataSource;

	 @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	        .jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select username,password,'true' as enabled from bookReader where username=?")
			.authoritiesByUsernameQuery(
				"select username, role from bookReader where username=?")
				.passwordEncoder(passwordEncoder())
				;
	    }
	     
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	       
	      http
	      .authorizeRequests()
	        .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
	        	.and()
	        .formLogin()
//	        	.and()
//	        .exceptionHandling().accessDeniedPage("/Access_Denied")
	        	.and()
	        .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
	        .csrf().csrfTokenRepository(csrfTokenRepository());
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    private CsrfTokenRepository csrfTokenRepository() {
			HttpSessionCsrfTokenRepository repository = 
					new HttpSessionCsrfTokenRepository();
			repository.setHeaderName("X-XSRF-TOKEN");
			return repository;
		}
	    
	
}