package reservio.restaurantmanagement.restaurant.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateRestaurantFormInfo;
import reservio.restaurantmanagement.restaurant.entity.Restaurant;
import reservio.restaurantmanagement.restaurant.service.RestaurantService;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/restaurantManagement")
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity createRestaurant(@NonNull @RequestBody final CreateUpdateRestaurantFormInfo formInfo) {
        return ResponseEntity.ok(this.restaurantService.createRestaurant(formInfo));
    }

    @PatchMapping("/restaurant/{id}")
    public ResponseEntity updateRestaurant(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateRestaurantFormInfo formInfo) {
        return ResponseEntity.ok(this.restaurantService.updateRestaurant(id, formInfo));
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable @NonNull final String id) {
        this.restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity getRestaurant(@PathVariable @NonNull final String id) {
        this.restaurantService.getRestaurant(id);
        return ResponseEntity.noContent().build();
    }

}
