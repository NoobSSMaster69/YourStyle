package org.example.config;

import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new ShopmeUserDetailsService();
//    }
//    @Autowired
    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService){
        this.userService=userService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                //Доступ только для не зарегистрированных пользователей
                .requestMatchers("/people/registration").hasAnyRole("ADMIN","USER")
                //Доступ только для пользователей с ролью Администратор
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/shop/categories").hasRole("USER")
                //Доступ разрешен всем пользователей
                .requestMatchers("/", "/people/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/people/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    //    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//    }
}
