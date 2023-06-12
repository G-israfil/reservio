package reservio.gatewayreservio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${app.urls.account-management}")
    private String accountManagementUrl;

    @Value("${app.urls.restaurant-management}")
    private String restaurantManagementUrl;

    @Value("${app.urls.reservation-management}")
    private String reservationManagementUrl;

    @Value("${app.urls.order-management}")
    private String orderManagementUrl;

    @Value("${app.urls.payment-management}")
    private String paymentManagementUrl;

    @Value("${app.urls.user-management}")
    private String userManagementUrl;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/accountManagement/**")
                        .uri(this.accountManagementUrl))
                .route(p -> p
                        .path("/restaurantManagement/**")
                        .uri(this.restaurantManagementUrl))
                .route(p -> p
                        .path("/reservationManagement/**")
                        .uri(this.reservationManagementUrl))
                .route(p -> p
                        .path("/orderManagement/**")
                        .uri(this.orderManagementUrl))
                .route(p -> p
                        .path("/paymentManagement/**")
                        .uri(this.paymentManagementUrl))
                .route(p -> p
                        .path("/userManagement/**")
                        .uri(this.userManagementUrl))
                .build();
    }

}
