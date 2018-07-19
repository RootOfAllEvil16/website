package com.project.eva.config;

import com.project.eva.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.project.eva.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private static final String ADMIN_REQUEST_URl = "/admin/**";

    private static final String LOGIN_URL = "/login";

    private static final String USERNAME = "username";

    private static final String PASSWORD = "password";

    private static final String ACCESS_DENIED_PAGE = "/forbidden_exception";


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(final HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity
                .logout()
                .invalidateHttpSession(false)
                .and()
                .authorizeRequests()
                .antMatchers(ADMIN_REQUEST_URl)
                .hasRole(UserRole.ADMIN.name())
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage(LOGIN_URL)
                .usernameParameter(USERNAME)
                .passwordParameter(PASSWORD)
                .defaultSuccessUrl("/", false)
                .and()
                .exceptionHandling().accessDeniedPage(ACCESS_DENIED_PAGE).and()
                .csrf().disable();
    }


    @Override
    protected void configure(final AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(this.userDetailsService);
    }
}
