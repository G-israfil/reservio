package reservio.storagemanagement.inventory.services;

import io.micrometer.common.util.StringUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateInventoryRecordFormInfo;
import reservio.storagemanagement.inventory.dao.InventoryRepository;
import reservio.storagemanagement.inventory.entity.InventoryRecord;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {
    private final ModelMapperHelper modelMapperHelper;
    private final InventoryRepository repository;
    public InventoryRecord createInventoryRecord(@NonNull CreateUpdateInventoryRecordFormInfo formInfo){
        final InventoryRecord inventoryRecord = modelMapperHelper.map(formInfo, InventoryRecord.class);
        return repository.save(inventoryRecord);
    }


    public InventoryRecord updateInventoryRecord(@NonNull CreateUpdateInventoryRecordFormInfo formInfo, @NonNull Long id){
        final InventoryRecord inventoryRecord = repository.findById(id).orElseThrow(() -> new NotFoundException("Inventory record not found with id " + id));
        if(!StringUtils.isEmpty(formInfo.getName())) inventoryRecord.setName(formInfo.getName());
        if(!StringUtils.isEmpty(formInfo.getDescription())) inventoryRecord.setDescription(formInfo.getDescription());
        if(!StringUtils.isEmpty(formInfo.getType())) inventoryRecord.setType(formInfo.getType());
        if(formInfo.getQuantity() != 0) inventoryRecord.setQuantity(formInfo.getQuantity());
        if(Objects.nonNull(formInfo.getWeight())) inventoryRecord.setWeight(formInfo.getWeight());
        return  repository.save(inventoryRecord);
    }

    public InventoryRecord getInventoryRecord(@NonNull Long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Inventory record not found with id " + id));
    }

    public void deleteInventoryRecord(@NonNull Long id){
        repository.deleteById(id);
    }
}
