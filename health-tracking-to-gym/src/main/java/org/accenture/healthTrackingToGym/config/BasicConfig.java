package org.accenture.healthTrackingToGym.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class BasicConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder){

        UserDetails admin = User.withUsername("sgomez")
                .password(passwordEncoder.encode("asd123"))
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return  passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        return http
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/tracking/member/{membershipId}")).authenticated())
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/tracking/{id}")).authenticated())
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/update/tracking/{id}")).authenticated())
                .authorizeHttpRequests(request->request.requestMatchers(new AntPathRequestMatcher("/delete/Tracking/{id}")).authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
