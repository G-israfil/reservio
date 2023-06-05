package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateRestaurantFormInfo {
    private String name;
    private String phone;
    private String managerName;
    private String managerPhone;
    private String contactEmail;
    private String description;
    private String country;
    private String city;
    private String address;
    private Boolean delivery;
    private Boolean pickup;
    private String username;
    private String email;
}
