package com.mobile.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private AuthenticationProvider stest;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("build Auth global");
		
//		String query1 = "select uid1 username, concat('{noop}',upw1) password, true enabled From tb1_members where uid1=?";
//		String query2 = "select member2 uid1, role_name role from tb1_member_roles where member2 = ?";
//		System.out.println(query1);
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery(query1)
//		.rolePrefix("ROLE_")
//		.authoritiesByUsernameQuery(query2);
		
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("admin")
		.roles("ADMIN");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(stest);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**");
//		web.ignoring().antMatchers("/app/**");
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

//	
		http.authorizeRequests().antMatchers("/").permitAll();
//		http.authorizeRequests().antMatchers("/shop/cart/orderForm","/shop/mypage/**","/shop/cart/**",
//				"/shop/cart/cartList","/community/register").hasRole("MEMBER");
//		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		
		
		http.formLogin().loginPage("/loginPage").defaultSuccessUrl("/admin/category");
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");
	//	 http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);
		
        http
        .csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
		
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.equals(encodedPassword);
				}
		
	};
}
}
	

