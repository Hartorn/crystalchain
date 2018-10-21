package com.github.hartorn.crystalchain.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String USER_QUERY = "select email, password, true from user where email=?";
  private static final String ROLES_QUERY =
      "select u.email,org.id from user u inner join organisation org on(u.organisation_id=org.id) where u.email=?";

  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
        .usersByUsernameQuery(USER_QUERY)
        .authoritiesByUsernameQuery(ROLES_QUERY)
        .dataSource(dataSource)
        .passwordEncoder(bCryptPasswordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
        .authorizeRequests().anyRequest().authenticated()
        .and().csrf().disable()
        .httpBasic()
        .and()
        .headers().frameOptions().sameOrigin();
    //          .loginPage("/login").failureUrl("/login?error=true")
    //          .defaultSuccessUrl("/admin/home")
    //          .usernameParameter("email")
    //          .passwordParameter("password")
    //          .and().logout()
    //          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    //          .logoutSuccessUrl("/").and().exceptionHandling()
    //          .accessDeniedPage("/access-denied");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .antMatchers(
            "/resources/**",
            "/static/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/swagger-ui.html",
            "console");
  }

  //  @Override
  //  protected void configure(HttpSecurity http) throws Exception {
  //    http.authorizeRequests()
  //        .antMatchers("/", "/home")
  //        .permitAll()
  //        .anyRequest()
  //        .authenticated();
  ////        .and()
  ////        .formLogin()
  ////        .loginPage("/login")
  ////        .permitAll()
  ////        .and()
  ////        .logout()
  ////        .permitAll();
  //  }

  //  @Bean
  //  @Override
  //  public UserDetailsService userDetailsService() {
  //    UserDetails user =
  //        User.withDefaultPasswordEncoder()
  //            .username("user")
  //            .password("password")
  //            .roles("USER")
  //            .build();
  //
  //    return new InMemoryUserDetailsManager(user);
  //  }
}
