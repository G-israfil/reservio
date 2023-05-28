//package reservio.usermanagement.config.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import reservio.usermanagement.user.dao.UserRepository;
//import reservio.usermanagement.user.entity.User;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//    private final UserRepository userRepository;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    // The SecurityFilterChain bean defines which URL paths should be secured
//    // and which should not.
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)
//            throws Exception {
//        http
//                .authorizeHttpRequests(request -> request.requestMatchers("auth/**").permitAll())
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/", "/home").permitAll()
//                        //.anyRequest().authenticated()
//                        .anyRequest().hasRole("USER")
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll)
//        ;
//        return http.build();
//    }
//
//    // UserDetailsService is used by DaoAuthenticationProvider for retrieving a username,
//    // a password, and other attributes for authenticating with a username and password
//    @Bean
//    public UserDetailService userDetailsService(DataSource dataSource) {
//        // Used by JPA (DaoAuthenticationProvider) authentication provider
//        return new UserDetailService();
//    }
//
//
//}
