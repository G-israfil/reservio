//package reservio.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import reservio.common.interceptor.TokenValidationInterceptor;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    private final TokenValidationInterceptor tokenValidationInterceptor;
//
//    public WebConfig(TokenValidationInterceptor tokenValidationInterceptor) {
//        this.tokenValidationInterceptor = tokenValidationInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenValidationInterceptor);
//    }
//}
