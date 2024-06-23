package az.ministry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder userBuilder=User.withDefaultPasswordEncoder();

        UserDetails user=userBuilder
                .username("user")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin=userBuilder
                .username("admin")
                .password("11111")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

}
