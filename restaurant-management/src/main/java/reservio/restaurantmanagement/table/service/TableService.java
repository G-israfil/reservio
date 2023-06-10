package reservio.restaurantmanagement.table.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reservio.common.contant.Contants;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateTableFormInfo;
import reservio.restaurantmanagement.table.dao.TableRepository;
import reservio.restaurantmanagement.table.entity.RTable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TableService {
    private final TableRepository repository;
    private final ModelMapperHelper modelMapperHelper;

    public RTable createTable(@NonNull final CreateUpdateTableFormInfo formInfo) {
        final RTable table = modelMapperHelper.map(formInfo, RTable.class);
        return repository.save(table);
    }

    public RTable updateTable(@NonNull final CreateUpdateTableFormInfo formInfo, @NonNull final Long id) {
        Optional<RTable> optionalTable = this.repository.findById(id);
        if (optionalTable.isPresent()) {
            RTable table = optionalTable.get();
            table = this.modelMapperHelper.map(formInfo, RTable.class);
            return this.repository.save(table);
        }
        throw new NotFoundException(Contants.ERROR_MESSAGES.TABLE_NOT_FOUND + id);
    }

    public void deleteTable(@NonNull final Long id) {
        this.repository.deleteById(id);
    }

    public RTable getTable(@NonNull final Long id) {
        final Optional<RTable> optionalTable = this.repository.findById(id);
        if (optionalTable.isPresent()) return optionalTable.get();
        throw new NotFoundException(Contants.ERROR_MESSAGES.TABLE_NOT_FOUND + id);
    }
}
