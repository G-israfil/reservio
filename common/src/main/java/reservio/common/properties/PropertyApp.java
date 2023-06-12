package reservio.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class PropertyApp {
    private PropertyQueue queue;
    private UrlMapping urls;
}
