package com.finalproject.cafegaming.config;

import com.finalproject.cafegaming.filter.CustomAccessDeniedHandler;
import com.finalproject.cafegaming.filter.JwtAuthenticationTokenFilter;
import com.finalproject.cafegaming.filter.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;


/**
 * @author AuPhan
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();


//        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/v1/authenticate","/api/v1/user").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/v1/booths").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/v1/user").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/v1/comment").permitAll();
//
//
//        http.authorizeRequests().antMatchers("/api/v1/users","/api/v1/provinces","/api/v1/districts")
//                .access("hasRole('ROLE_ADMIN')");
//        http.authorizeRequests().antMatchers("/api/v1/**")
//                .access("hasRole('ROLE_ADMIN') or hasAnyRole('ROLE_PARTNER')" );


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.antMatcher("/api/v1/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint());


        http.cors().configurationSource(request -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(Collections.singletonList("*"));
            cors.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(Collections.singletonList("*"));
            return cors;
        });
        /*
         * add filter thỏa điều kiện rồi mới vào Controller
         */
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
}
