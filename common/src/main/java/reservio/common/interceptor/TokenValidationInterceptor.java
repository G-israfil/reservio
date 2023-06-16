package reservio.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import reservio.common.util.JwtUtils;


@Component
public class TokenValidationInterceptor implements HandlerInterceptor {
    private final JwtUtils jwtUtils;

    public TokenValidationInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        String requestPath = request.getRequestURI();
        if (requestPath.contains("auth")) {
            return true;
        }
        if (isValidToken(token)) {
            return true; // Token is valid
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false; // Token is invalid
        }
    }

    private boolean isValidToken(String token) {
        if(token != null && !token.isEmpty()){
            jwtUtils.verify(token);
            return true;
        }
        return false;
    }
}
