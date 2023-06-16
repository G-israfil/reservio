package reservio.common.clients;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservio.common.models.response.AccountCreateUpdateResponse;

@Service
@RequiredArgsConstructor
public class AccountManagementClientService {

    @Value("${app.urls.account-management}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public AccountCreateUpdateResponse getAccount(@NonNull String id){
        return restTemplate.getForObject(baseUrl+id, AccountCreateUpdateResponse.class);
    }
}
