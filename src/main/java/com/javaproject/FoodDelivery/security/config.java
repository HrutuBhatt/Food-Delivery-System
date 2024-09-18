package com.javaproject.FoodDelivery.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class config {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager udm =  new JdbcUserDetailsManager(dataSource);
        udm.setUsersByUsernameQuery("select * from members where user_id = ?");
        udm.setAuthoritiesByUsernameQuery("select * from roles where user_id = ?");
        return udm;
    }

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
    {
     http.authorizeHttpRequests(config ->
            config
                    .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/orders/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/orders").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/orders").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/orders").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/orderItems").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/orderItems/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET , "/items").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT , "/items").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET , "/items").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET , "/deliverymen").hasRole("ADMIN")
                    .anyRequest().permitAll()



     );

     http.httpBasic(Customizer.withDefaults());
     http.csrf(csrf -> csrf.disable() );

     return http.build();
    }

}