package ro.sda.javaremote31.springModule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigCustom extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").roles("USER").password("{noop}password")
                .and()
                .withUser("admin").roles("ADMIN").password("{noop}password")
                ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/books").permitAll()
                .antMatchers("/books/delete/**").hasRole("ADMIN")
                .antMatchers("/books/create").hasAnyRole("USER","ADMIN")
                .antMatchers("/books/edit/**").hasRole("ADMIN")
                .antMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll().defaultSuccessUrl("/books",true)
                .and()
                .logout().permitAll().clearAuthentication(true)
                ;
    }
}
