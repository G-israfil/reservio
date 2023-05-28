package reservio.common.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUpdateAddressFormInfo {
    private String streetName;

    private String apartmanNo;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private String suiteNumber;

    private String neighbourhood;
}
