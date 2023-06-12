package reservio.common.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AccountManagementService {

    @Value("${app.urls.account-management}")
    private String baseUrl;

    private final RestTemplate restTemplate;
}
