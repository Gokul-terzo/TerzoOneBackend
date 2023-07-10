//package com.terzoOne.terzoOneBackend.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import javax.sql.DataSource;
//@Configuration
//public class Security {
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        // define query to retrieve a user by username
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select email, password, enabled from users where email=?");
//
//        // define query to retrieve the authorities/roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select email, role from authorities where email=?");
//        return jdbcUserDetailsManager;
//    }
//    //
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE","ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/employee/**").hasAnyRole("EMPLOYEE","ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/api/employee/new").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/employee/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/employee/**").hasRole("ADMIN")
//        );
//        //USE HTTP BASIC AUTHENTICATION
//        http.httpBasic(Customizer.withDefaults());
//        //DISABLE CROSS SITE REQUEST FORGERY(CSRF)
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//}
