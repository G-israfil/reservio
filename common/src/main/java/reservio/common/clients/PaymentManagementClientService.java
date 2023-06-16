package reservio.common.clients;


import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservio.common.models.response.PaymentMethodCreateUpdateResponse;

@Service
@RequiredArgsConstructor
public class PaymentManagementClientService {
    private final RestTemplate restTemplate;

    @Value("${app.urls.payment-management}")
    private String baseUrl;

    public PaymentMethodCreateUpdateResponse getAccount(@NonNull String id) {
        return restTemplate.getForObject(baseUrl + id, PaymentMethodCreateUpdateResponse.class);
    }

    public PaymentMethodCreateUpdateResponse getAccountByType(@NonNull String type){
        return restTemplate.getForObject(baseUrl+"/paymentMethod/paymentMethodtype?type="+type,PaymentMethodCreateUpdateResponse.class);
    }

}
