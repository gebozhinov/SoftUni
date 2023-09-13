package bg.softuni.Mobilelele.config;

import bg.softuni.Mobilelele.repository.UserRepository;
import bg.softuni.Mobilelele.service.UserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;


@Configuration
public class Config {

    // Here we have to expose 3 things:
    // 1. Password encoder
    // 2. SecurityFilterChain
    // 3. UserDetailsService

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   SecurityContextRepository securityContextRepository) throws Exception {

        httpSecurity
                // define which request are allowed and which not
                .authorizeHttpRequests((authorize) -> authorize
                        // everyone can download static resources (css, js, images)
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // everyone can log in and register
                        .requestMatchers("/", "/users/login", "/users/register").permitAll()
                        // all other pages are available for logger in users
                        .anyRequest().authenticated()
                )
                // configuration of form login
                .formLogin(
                        (form) -> form
                                // the custom login form
                                .loginPage("/users/login")
                                // the name of the username form field
                                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                // the name of the password form field
                                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                                // where to go in case that the login is successful
                                .defaultSuccessUrl("/")
                                // where to go in case that the login failed
                                .failureForwardUrl("/users/login")

                )
                // configure logout
                .logout((logout) -> logout
                        // which is the logout url, must be POST request
                        .logoutUrl("/users/logout")
                        // on logout go to the home page
                        .logoutSuccessUrl("/")
                        // invalidate the session and delete the cookies
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .securityContext((context) -> context
                        .securityContextRepository(securityContextRepository)
                );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailService userDetailService(UserRepository userRepository) {
        return new UserDetailService(userRepository);
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
}
