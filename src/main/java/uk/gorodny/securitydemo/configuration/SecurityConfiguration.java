package uk.gorodny.securitydemo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Создание пользователя при помощи UserService
        // auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("{noop}pass1")
                .roles("ADMIN")
                .and()
                .withUser("user2")
                .password("{noop}pass2")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //авторизация фронта. говоярт в крупных приложениях не нужен :)
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN") //...одна роль
                .antMatchers("/user").hasAnyRole("ADMIN", "USER") //...список ролей
//                .antMatchers("/all-auth-users").authenticated() //все залогиненые
                .antMatchers("/**", "/hello").permitAll() // все //.anonymous?
                .and()
                .formLogin()
                .and()
                .logout();
    }
}
