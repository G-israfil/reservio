package reservio.storagemanagement.inventory.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservio.common.models.request.CreateUpdateInventoryRecordFormInfo;
import reservio.storagemanagement.inventory.entity.InventoryRecord;
import reservio.storagemanagement.inventory.services.InventoryService;

@RestController
@RequestMapping("/inventoryManagement")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    @PostMapping("/inventory")
    public ResponseEntity<InventoryRecord> createInventoryRecord(@NonNull @RequestBody CreateUpdateInventoryRecordFormInfo formInfo){
        return ResponseEntity.ok(inventoryService.createInventoryRecord(formInfo));
    }

    @PatchMapping("/inventory/{id}")
    public ResponseEntity<InventoryRecord> updateInventoryRecord(@NonNull @RequestBody CreateUpdateInventoryRecordFormInfo formInfo, @PathVariable @NonNull Long id){
        return ResponseEntity.ok(inventoryService.updateInventoryRecord(formInfo,id));
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<InventoryRecord> getInventoryRecord(@PathVariable @NonNull Long id){
        return ResponseEntity.ok(inventoryService.getInventoryRecord(id));
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Void> deleteInventoryRecord(@PathVariable @NonNull Long id){
        inventoryService.deleteInventoryRecord(id);
        return ResponseEntity.noContent().build();
    }
}
