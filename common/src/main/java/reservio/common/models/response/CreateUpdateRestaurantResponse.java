package reservio.common.models.response;
import lombok.Data;
import reservio.common.util.CommonUtils;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateUpdateRestaurantResponse {

    private Long id = CommonUtils.generateUUID();

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

    private int floorCount;

    private List<CreateUpdateFloorResponse> floors;


    private Long ownerId;


    private LocalDateTime createdDate;


    private LocalDateTime lastUpdatedDate;
}
