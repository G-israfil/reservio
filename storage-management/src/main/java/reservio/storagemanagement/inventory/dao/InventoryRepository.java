package reservio.storagemanagement.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import reservio.storagemanagement.inventory.entity.InventoryRecord;

public interface InventoryRepository extends JpaRepository<InventoryRecord,Long> {
}
