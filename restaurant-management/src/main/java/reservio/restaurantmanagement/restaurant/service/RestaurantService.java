package reservio.restaurantmanagement.restaurant.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateRestaurantFormInfo;
import reservio.restaurantmanagement.restaurant.dao.RestaurantRepository;
import reservio.restaurantmanagement.restaurant.entity.Restaurant;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {
    private final RestaurantRepository repository;
    private final ModelMapperHelper modelMapperHelper;

    public Restaurant createRestaurant(@NonNull @RequestBody CreateUpdateRestaurantFormInfo formInfo) {
        final Restaurant restaurant = modelMapperHelper.map(formInfo, Restaurant.class);
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

    public void deleteRestaurant(@PathVariable @NonNull final String id) {
        final Optional<Restaurant> optionalRestaurant = this.repository.findById(Long.parseLong(id));
        if (optionalRestaurant.isPresent()) {
            this.repository.deleteById(Long.parseLong(id));
            return;
        }
            throw new NotFoundException("Restaurant not found with given id: " + id);
    }

    public Restaurant getRestaurant(@PathVariable @NonNull final String id) {
        final Optional<Restaurant> optionalRestaurant = this.repository.findById(Long.parseLong(id));
        if (optionalRestaurant.isPresent()) {
            return optionalRestaurant.get();
        }
        throw new NotFoundException("Restaurant not found with given id: " + id);
    }
}