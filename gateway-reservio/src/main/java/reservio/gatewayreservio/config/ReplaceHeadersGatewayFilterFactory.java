//package reservio.gatewayreservio.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ReplaceHeadersGatewayFilterFactory extends AbstractGatewayFilterFactory<ReplaceHeadersGatewayFilterFactory.Config> {
//
//    public ReplaceHeadersGatewayFilterFactory() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            HttpHeaders headers = exchange.getRequest().getHeaders();
//            headers.set(HttpHeaders.ACCEPT, "*/*");
//
//            // Forward the modified request to the next filter or route
//            return chain.filter(exchange);
//        };
//    }
//
//    public static class Config {
//        private String headerName;
//        private String headerValue;
//
//        // Getters and setters
//
//        public String getHeaderName() {
//            return headerName;
//        }
//
//        public void setHeaderName(String headerName) {
//            this.headerName = headerName;
//        }
//
//        public String getHeaderValue() {
//            return headerValue;
//        }
//
//        public void setHeaderValue(String headerValue) {
//            this.headerValue = headerValue;
//        }
//    }
//}
