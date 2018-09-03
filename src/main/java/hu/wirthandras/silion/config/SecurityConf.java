package hu.wirthandras.silion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private H2ConsoleProperties console;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
		  .inMemoryAuthentication()
		    .withUser("user") 
		    .password("1234")
		    .roles("USER")
		   .and()
             .withUser("sfjadmin")
             .password("pass")
             .roles("ADMIN");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		
		String path = this.console.getPath();
        String antPattern = (path.endsWith("/") ? path + "**" : path + "/**");
        HttpSecurity h2Console = httpSec.antMatcher(antPattern);
        h2Console.csrf().disable();
        h2Console.httpBasic();
        h2Console.headers().frameOptions().sameOrigin();
		
		
	   httpSec
		  .authorizeRequests()
			   .antMatchers(HttpMethod.GET,"/").permitAll()
               .antMatchers("/delete").hasRole("ADMIN") 
               .antMatchers("/admin/**").hasRole("ADMIN")
             .and()
   			  .formLogin()
   		       .permitAll();
	}
	
	
	

	
	
}