package reservio.restaurantmanagement.restaurant.controller;

import io.micrometer.common.util.StringUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservio.common.exceptions.UnAuthorizedException;
import reservio.common.models.request.CreateUpdateRestaurantFormInfo;
import reservio.restaurantmanagement.restaurant.entity.Restaurant;
import reservio.restaurantmanagement.restaurant.service.RestaurantService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/restaurantManagement")
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestHeader @NonNull String authorization,@NonNull @RequestBody final CreateUpdateRestaurantFormInfo formInfo) {
        if(StringUtils.isEmpty(authorization)) throw new UnAuthorizedException("Token is not valid");
        return ResponseEntity.ok(this.restaurantService.createRestaurant(formInfo,authorization));
    }

    @PatchMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateRestaurantFormInfo formInfo) {
        return ResponseEntity.ok(this.restaurantService.updateRestaurant(id, formInfo));
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable @NonNull final String id) {
        this.restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable @NonNull final Long id) {
        return ResponseEntity.ok(this.restaurantService.getRestaurant(id));
    }
    @GetMapping("/restaurantAll")
    public ResponseEntity<List<Restaurant>> getAllRestaurant() {
        List<Restaurant> restaurants = this.restaurantService.getAllRestaurant();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/restaurant")
    public ResponseEntity<List<Long>> listRestaurantIdsByUserId(@RequestParam @NonNull final Long userId) {
        return ResponseEntity.ok(this.restaurantService.listRestaurantIdsByUserId(userId));
    }

}
