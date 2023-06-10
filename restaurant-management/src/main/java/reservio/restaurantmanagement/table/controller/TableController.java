package reservio.restaurantmanagement.table.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateTableFormInfo;
import reservio.restaurantmanagement.table.entity.RTable;
import reservio.restaurantmanagement.table.service.TableService;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/restaurantManagement/tableManagement")
@Slf4j
public class TableController {

    private final TableService tableService;

    @PostMapping("/restaurant")
    public ResponseEntity<RTable> createRestaurant(@NonNull @RequestBody final CreateUpdateTableFormInfo formInfo) {
        return ResponseEntity.ok(this.tableService.createTable(formInfo));
    }

    @PatchMapping("/restaurant/{id}")
    public ResponseEntity<RTable> updateRestaurant(@PathVariable @NonNull final String id, @NonNull @RequestBody final CreateUpdateTableFormInfo formInfo) {
        return ResponseEntity.ok(this.tableService.updateTable(formInfo, Long.parseLong(id)));
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable @NonNull final String id) {
        this.tableService.deleteTable(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<RTable> getRestaurant(@PathVariable @NonNull final String id) {
        return ResponseEntity.ok(this.tableService.getTable(Long.parseLong(id)));
    }
}
