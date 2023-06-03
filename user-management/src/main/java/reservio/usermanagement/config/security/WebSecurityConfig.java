//package reservio.usermanagement.config.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import reservio.usermanagement.user.services.UserDetailService;
//
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig  {
//
//    private final UserDetailService userDetailService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)
//            throws Exception {
////        http
////                .authorizeHttpRequests(request -> request.requestMatchers("auth/**").permitAll())
////                .authorizeHttpRequests(request -> request.requestMatchers("/swagger-ui/**").permitAll())
////                .authorizeHttpRequests(request -> request.requestMatchers("/userManagement/**").permitAll())
////                .authorizeHttpRequests(requests -> requests
////                        .requestMatchers("/", "/home").permitAll()
////                        //.anyRequest().authenticated()
////                        .anyRequest().hasRole("USER")
////                )
////                .formLogin(form -> form
////                        .loginPage("/login")
////                        .permitAll()
////                )
////                .logout(LogoutConfigurer::permitAll)
//        http
//                .authorizeHttpRequests(request -> request.anyRequest().permitAll());
//
//        ;
//        return http.build();
//    }
//
//
////    @Bean
////    protected void configure(AuthenticationManagerBuilder auth){
////        auth.authenticationProvider(daoAuthenticationProvider());
////    }
//
////    @Bean
////    public DaoAuthenticationProvider daoAuthenticationProvider(){
////        final DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
////        provider.setPasswordEncoder(bCryptPasswordEncoder());
////        provider.setUserDetailsService(userDetailService);
////        return provider;
////
////    }
////    @Bean
////    public BCryptPasswordEncoder bCryptPasswordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//}
