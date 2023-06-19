//package com.bies.notification.confic;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
////        httpSecurity
////                .authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .cors()
////                .and()
////                .csrf()
////                .disable()
////                .oauth2ResourceServer()
////                .jwt();
//
//        httpSecurity
//                .csrf()
//                .disable()
//                .oauth2Client();
//        httpSecurity
//                .authorizeRequests().anyRequest().permitAll();
//
//        return httpSecurity.build();
//    }
//
//}
