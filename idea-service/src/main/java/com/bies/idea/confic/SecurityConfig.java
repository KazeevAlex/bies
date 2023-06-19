package com.bies.idea.confic;

import com.bies.idea.dto.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final String authoritiesClaimName;
    private final String authorityPrefix;

    public SecurityConfig(
            @Value("${jwt.authority.claim-name}") String authoritiesClaimName,
            @Value("${jwt.authority.prefix}") String authorityPrefix
    ) {
        this.authoritiesClaimName = authoritiesClaimName;
        this.authorityPrefix = authorityPrefix;
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthoritiesClaimName(authoritiesClaimName);
        grantedAuthoritiesConverter.setAuthorityPrefix(authorityPrefix);

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
//        return jwtAuthenticationConverter;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/api/idea/home").hasAuthority("SCOPE_service");
//                    auth.requestMatchers("/api/idea/user").hasRole("USER");
                    auth.requestMatchers("/api/idea")
                            .hasAnyAuthority(
                                    UserRole.EXPERT.name(),
                                    UserRole.USER.name()
                                    , "SERVICE"
                            );
                    auth.anyRequest().authenticated();
                })
//                .oauth2Client()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable);
//                .httpBasic(Customizer.withDefaults());


//        httpSecurity
//                .authorizeHttpRequests()
//                .requestMatchers("/api/idea/home").permitAll()
//                .requestMatchers("/api/idea/expert").hasRole("EXPERT")
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .httpBasic();


//        httpSecurity
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/api/idea/home").permitAll();
////                    auth.requestMatchers("/api/idea/user").hasRole("USER");
//                    auth.requestMatchers("/api/idea/expert").hasRole("EXPERT");
//                    auth.anyRequest().authenticated();
//                })
//                .csrf(AbstractHttpConfigurer::disable)
//                .httpBasic(Customizer.withDefaults());

//        httpSecurity
//                .csrf()
//                .disable()
//                .oauth2Client();
//        httpSecurity
//                .authorizeRequests().anyRequest().permitAll();

        return httpSecurity.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}user")
//                .roles("USER")
//                .build();
//
//        UserDetails expert = User.builder()
//                .username("expert")
//                .password("{noop}expert")
//                .roles("EXPERT")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, expert);
//    }

}
