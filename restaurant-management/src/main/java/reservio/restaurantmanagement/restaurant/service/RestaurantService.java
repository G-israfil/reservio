package reservio.restaurantmanagement.restaurant.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateRestaurantFormInfo;
import reservio.common.models.response.CreateUpdateRestaurantResponse;
import reservio.common.util.JwtUtils;
import reservio.restaurantmanagement.floor.entity.Floor;
import reservio.restaurantmanagement.restaurant.dao.RestaurantRepository;
import reservio.restaurantmanagement.restaurant.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {
    private final RestaurantRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    private final JwtUtils jwtUtils;

    public Restaurant createRestaurant(@NonNull @RequestBody CreateUpdateRestaurantFormInfo formInfo,String authHeader) {
        Long userId = jwtUtils.extractUserId(authHeader);
        final Restaurant restaurant = modelMapperHelper.map(formInfo, Restaurant.class);
        restaurant.setOwnerId(userId);
        return this.repository.save(restaurant);
    }

    public Restaurant updateRestaurant(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateRestaurantFormInfo formInfo) {
        final Optional<Restaurant> optionalReservation = this.repository.findById(Long.parseLong(id));
        Optional<Restaurant> optionalRestaurant = repository.findById(Long.parseLong(id));
        if (optionalRestaurant.isPresent()) {
            final Restaurant restaurant = optionalRestaurant.get();
            restaurant.setName(formInfo.getName());
            restaurant.setPhone(formInfo.getPhone());
            restaurant.setContactEmail(formInfo.getContactEmail());
            restaurant.setManagerName(formInfo.getManagerName());
            restaurant.setManagerPhone(formInfo.getManagerPhone());
            restaurant.setAddress(formInfo.getAddress());
            restaurant.setDescription(formInfo.getDescription());
            restaurant.setDelivery(formInfo.getDelivery());
            restaurant.setPickup(formInfo.getPickup());
            return this.repository.save(restaurant);
        }
        throw new NotFoundException("Restaurant not found with given id: " + id);
    }

    public void addFloor(@NonNull List<Floor> floors,@NonNull Long id){
        final Restaurant restaurant = this.repository.findById(id).orElseThrow(() ->new NotFoundException("Restaurant not found id:" + id));

        if(ObjectUtils.isEmpty(restaurant.getFloors())) restaurant.setFloors(new ArrayList<>());

        floors.forEach(floor -> restaurant.getFloors().add(floor));

        this.repository.save(restaurant);
    }
    public void deleteRestaurant(@PathVariable @NonNull final String id) {
        final Optional<Restaurant> optionalRestaurant = this.repository.findById(Long.parseLong(id));
        if (optionalRestaurant.isPresent()) {
            this.repository.deleteById(Long.parseLong(id));
            return;
        }
            throw new NotFoundException("Restaurant not found with given id: " + id);
    }

    public Restaurant getRestaurant(@PathVariable @NonNull final Long id) {
        final Optional<Restaurant> optionalRestaurant = this.repository.findById(id);
        if (optionalRestaurant.isPresent()) {
            return optionalRestaurant.get();
        }
        throw new NotFoundException("Restaurant not found with given id: " + id);
    }

    public List<Long> listRestaurantIdsByUserId(@PathVariable @NonNull final Long id) {
        return this.repository.findAllByOwnerId(id).stream().map(Restaurant::getId).collect(Collectors.toList());
    }
    public List<Restaurant> getAllRestaurant(){
        return this.repository.findAll();
    }
}
