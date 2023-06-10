package reservio.restaurantmanagement.floor.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateFloorFormInfo;
import reservio.common.models.request.CreateUpdateTableFormInfo;
import reservio.common.util.CommonUtils;
import reservio.restaurantmanagement.floor.dao.FloorRepository;
import reservio.restaurantmanagement.floor.entity.Floor;
import reservio.restaurantmanagement.restaurant.dao.RestaurantRepository;
import reservio.restaurantmanagement.restaurant.entity.Restaurant;
import reservio.restaurantmanagement.restaurant.service.RestaurantService;
import reservio.restaurantmanagement.table.service.TableService;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final ModelMapperHelper modelMapperHelper;
    private final FloorRepository repository;
    private final RestaurantService restaurantService;
    public Floor createRestaurant(@NonNull @RequestBody CreateUpdateFloorFormInfo formInfo) {
        final Floor floor = modelMapperHelper.map(formInfo, Floor.class);

        floor.setId(CommonUtils.generateUUID());
        floor.setCapacity(formInfo.getTables().stream().map(CreateUpdateTableFormInfo::getChair).mapToInt(Integer::intValue).sum());

        final Floor createdFloor = this.repository.save(floor);
        this.restaurantService.addFloor(Collections.singletonList(floor),formInfo.getRestaurantId());
        return createdFloor;
    }

    public Floor updateFloor(@PathVariable @NonNull final Long id, @NonNull @RequestBody final CreateUpdateFloorFormInfo formInfo) {
        final Optional<Floor> optionalFloor = this.repository.findById(id);
        if (optionalFloor.isPresent()) {
            Floor floor = optionalFloor.get();
            floor = modelMapperHelper.map(formInfo, Floor.class);
            floor.setId(id);
            floor.setCapacity(formInfo.getTables().stream().map(CreateUpdateTableFormInfo::getChair).mapToInt(Integer::intValue).sum());
            return this.repository.save(floor);
        }
        throw new NotFoundException("Restaurant not found with given id: " + id);
    }

    public void deleteFloor(@PathVariable @NonNull final Long id) {
        final Optional<Floor> optionalRestaurant = this.repository.findById(id);
        if (optionalRestaurant.isPresent()) {
            this.repository.deleteById(id);
            return;
        }
        throw new NotFoundException("Restaurant not found with given id: " + id);
    }

    public Floor getFloor(@PathVariable @NonNull final Long id) {
        final Optional<Floor> optionalFloor = this.repository.findById(id);
        if (optionalFloor.isPresent()) {
            return optionalFloor.get();
        }
        throw new NotFoundException("Restaurant not found with given id: " + id);
    }
}
