package com.invillia.acme.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
            .csrf().disable().authorizeRequests()
            .antMatchers("/v2/api-docs").permitAll() 
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .anyRequest().authenticated()
            .and()

            // filter login requests
            .addFilterBefore(
                new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)

            // filter other requests to verify JWT on the header
            .addFilterBefore(
                new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        // create default account
        auth
            .inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("admin")
            .password("p4ssw0rd")
            .roles("ADMIN");
    }
}
