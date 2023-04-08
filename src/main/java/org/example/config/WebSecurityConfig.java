package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    private final DataSource dataSource;
    private final AuthenticationConfiguration authConfiguration;

    @Autowired
    public WebSecurityConfig(DataSource dataSource, AuthenticationConfiguration authConfiguration) {
        this.dataSource = dataSource;
        this.authConfiguration = authConfiguration;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select userLogin, userPass, userEnable from user where userLogin=?")
                .authoritiesByUsernameQuery("SELECT `user`.`userLogin`, `role`.`roleName`\n" +
        "FROM `user` INNER JOIN `user_role` ON `user`.`userId`=`user_role`.`userId`\n" +
        "join role on `user_role`.`roleId`=`role`.`roleId` where `user`.`userLogin`=?"
                ).passwordEncoder(passwordEncoder());
    }
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/").denyAll()
                .requestMatchers("/resources/**","/registration").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .requestMatchers("/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .httpBasic().disable();

        return http.build();
    }
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

}

