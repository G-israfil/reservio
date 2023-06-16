package reservio.common.models.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class DashboardAnalyticResponse {
    private String intervalType;
    private Map<Integer,Integer> valueMap;
    private Integer totalEntities;
}
