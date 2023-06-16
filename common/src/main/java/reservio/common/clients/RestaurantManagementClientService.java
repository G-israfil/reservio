package reservio.common.clients;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservio.common.models.response.AccountCreateUpdateResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantManagementClientService {

    @Value("${app.urls.restaurant-management}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public List<Long> getRestaurantByUserId(@NonNull Long id) {
        final String requestUrl = baseUrl + "/restaurant?userId=" + id;
        log.info("Request url: {}", requestUrl);
        ParameterizedTypeReference<List<Long>> responseType = new ParameterizedTypeReference<List<Long>>() {};
        ResponseEntity<List<Long>> response = restTemplate.exchange(requestUrl, HttpMethod.GET, null, responseType);
        return response.getBody();
    }
}
