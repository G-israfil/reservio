//package reservio.common.interceptor;
//
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.EurekaClient;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import reservio.common.util.JwtUtils;
//
//
//@Component
//public class TokenValidationInterceptor implements HandlerInterceptor {
//    private final JwtUtils jwtUtils;
//    private final EurekaClient eurekaClient;
//
//    public TokenValidationInterceptor(JwtUtils jwtUtils, EurekaClient eurekaClient) {
//        this.jwtUtils = jwtUtils;
//        this.eurekaClient = eurekaClient;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String token = request.getHeader("Authorization");
//        String requestPath = request.getRequestURI();
//        String sourceServiceId = request.getHeader("X-Eureka-Source-Service-Id");
//
//        if (sourceServiceId != null) {
//            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(sourceServiceId, false);
//            if (instanceInfo != null && instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
//                // Skip interception for service-to-service requests
//                return true;
//            }
//        }
//        if (requestPath.contains("auth")) {
//            return true;
//        }
//        if (requestPath.contains("restaurantAll")) {
//            return true;
//        }
//        if (isValidToken(token)) {
//            return true; // Token is valid
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false; // Token is invalid
//        }
//    }
//
//    private boolean isValidToken(String token) {
//        if(token != null && !token.isEmpty()){
//            jwtUtils.verify(token);
//            return true;
//        }
//        return false;
//    }
//}
