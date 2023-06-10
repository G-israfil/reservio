package reservio.restaurantmanagement.floor.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateFloorFormInfo;
import reservio.restaurantmanagement.floor.entity.Floor;
import reservio.restaurantmanagement.floor.service.FloorService;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/restaurantManagement/floorManagement")
public class FloorController {

    private final FloorService floorService;
    @PostMapping("/floor")
    public ResponseEntity<Floor> createRestaurant(@NonNull @RequestBody final CreateUpdateFloorFormInfo formInfo) {
        return ResponseEntity.ok(this.floorService.createRestaurant(formInfo));
    }

    @PatchMapping("/floor/{id}")
    public ResponseEntity<Floor> updateRestaurant(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateFloorFormInfo formInfo) {
        return ResponseEntity.ok(this.floorService.updateFloor(Long.parseLong(id), formInfo));
    }

    @DeleteMapping("/floor/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable @NonNull final String id) {
        this.floorService.deleteFloor(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/floor/{id}")
    public ResponseEntity<Floor> getRestaurant(@PathVariable @NonNull final String id) {
        return ResponseEntity.ok(this.floorService.getFloor(Long.parseLong(id)));
    }
}
