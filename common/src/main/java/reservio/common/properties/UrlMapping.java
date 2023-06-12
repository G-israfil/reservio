package reservio.common.properties;

import lombok.Data;

@Data
public class UrlMapping {
    private String account;
    private String orderManagement;
    private String paymentManagement;
    private String userManagement;
    private String storageManagement;
    private String reservationManagement;
    private String restaurantManagement;

}
