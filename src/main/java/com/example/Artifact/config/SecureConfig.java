package com.example.Artifact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecureConfig extends WebSecurityConfigurerAdapter {
@Autowired
    DataSource dataSource;
@Override
    protected void configure(HttpSecurity http) throws  Exception{
    http.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").permitAll();


}
@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{

    auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select login, password, is_enabled from users where login=?").
            authoritiesByUsernameQuery("select u.login, ur.role_name as role from user_roles ur inner join users u on ur.users_id = u.id where u.login=?");

}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
