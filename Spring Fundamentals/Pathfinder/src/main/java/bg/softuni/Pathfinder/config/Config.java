package bg.softuni.Pathfinder.config;

import bg.softuni.Pathfinder.service.AppUserDetailService;
import bg.softuni.Pathfinder.service.AuthService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class Config {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

      return   httpSecurity.authorizeHttpRequests(authorize -> authorize
                      .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                      .requestMatchers("/").permitAll()
                      .requestMatchers("/routes").permitAll()
                      .requestMatchers("routes/new").authenticated()
                      .requestMatchers("/register", "/login").anonymous()
                      .anyRequest().authenticated()
                ).formLogin(login -> login
                      .loginPage("/login")
                      .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                      .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                      .defaultSuccessUrl("/")
                      .failureUrl("/login?error")
                ).logout(logout -> logout
                      .logoutUrl("/logout")
                      .logoutSuccessUrl("/")
                      .deleteCookies("JSESSIONID")
                      .clearAuthentication(true)

              ).build();
    }

}
