package reservio.productcatalogmanagement.productcatalog.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reservio.common.contant.Contants;
import reservio.common.enums.Status;
import reservio.common.exceptions.NotFoundException;
import reservio.common.mappers.ModelMapperHelper;
import reservio.common.models.request.CreateUpdateProductSpecificationFormInfo;
import reservio.productcatalogmanagement.productcatalog.dao.ProductSpecificationRepository;
import reservio.productcatalogmanagement.productcatalog.entity.ProductSpecification;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCatalogService {

    private final ProductSpecificationRepository repository;
    private final ModelMapperHelper modelMapperHelper;
    public ProductSpecification createProductSpecification(@NonNull CreateUpdateProductSpecificationFormInfo formInfo){
        final ProductSpecification productSpecification = modelMapperHelper.map(formInfo,ProductSpecification.class);
        productSpecification.setStatus(Status.ACTIVE);
        return repository.save(productSpecification);
    }

    public ProductSpecification updateProductSpecification(@NonNull Long id,@NonNull CreateUpdateProductSpecificationFormInfo formInfo){
        final Optional<ProductSpecification> optionalProductSpecification = this.repository.findById(id);
        if(optionalProductSpecification.isPresent()){
            ProductSpecification productSpecification = optionalProductSpecification.get();
            productSpecification = modelMapperHelper.map(formInfo, ProductSpecification.class);
            productSpecification.setId(id);
            this.repository.save(productSpecification);
            return productSpecification;
        }
        throw new NotFoundException(Contants.ErrorMessage.PRODUCT_SPECIFICATION_NOT_FOUND + id);
    }

    public void cancelProductSpecification(@NonNull Long id){
        final Optional<ProductSpecification> optionalProductSpecification = this.repository.findById(id);
        if(optionalProductSpecification.isPresent()){
            final ProductSpecification productSpecification = optionalProductSpecification.get();
            productSpecification.setStatus(Status.CANCELLED);
            this.repository.save(productSpecification);
        }
        throw new NotFoundException(Contants.ErrorMessage.PRODUCT_SPECIFICATION_NOT_FOUND + id);
    }
    public void activateProductSpecification(@NonNull Long id){
        final Optional<ProductSpecification> optionalProductSpecification = this.repository.findById(id);
        if(optionalProductSpecification.isPresent()){
            final ProductSpecification productSpecification = optionalProductSpecification.get();
            productSpecification.setStatus(Status.ACTIVE);
            this.repository.save(productSpecification);
        }
        throw new NotFoundException(Contants.ErrorMessage.PRODUCT_SPECIFICATION_NOT_FOUND + id);
    }
    public void deleteProductSpecification(@NonNull Long id){
        repository.findById(id);
    }

    public ProductSpecification getProductSpecification(@NonNull Long id){
        final Optional<ProductSpecification> optionalProductSpecification = this.repository.findById(id);
        if(optionalProductSpecification.isPresent()){
            return optionalProductSpecification.get();
        }
        throw new NotFoundException(Contants.ErrorMessage.PRODUCT_SPECIFICATION_NOT_FOUND + id);
    }
}
