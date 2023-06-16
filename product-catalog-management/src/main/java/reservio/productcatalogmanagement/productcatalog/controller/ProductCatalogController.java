package reservio.productcatalogmanagement.productcatalog.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reservio.common.contant.Contants;
import reservio.common.models.request.CreateUpdateProductSpecificationFormInfo;
import reservio.productcatalogmanagement.productcatalog.entity.ProductSpecification;
import reservio.productcatalogmanagement.productcatalog.service.ProductCatalogService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productCatalogManagement")
@Slf4j
public class ProductCatalogController {
    private final ProductCatalogService productCatalogService;
    @PostMapping("/productSpecification")
    private ResponseEntity<ProductSpecification> createProductSpecification(@RequestBody @NonNull final CreateUpdateProductSpecificationFormInfo formInfo){
        return ResponseEntity.ok(this.productCatalogService.createProductSpecification(formInfo));
    }
    @PatchMapping("/productSpecification/{id}")
    private ResponseEntity<ProductSpecification> updateProductSpecification(@PathVariable @NonNull String id,@RequestBody @NonNull final CreateUpdateProductSpecificationFormInfo formInfo){
        return ResponseEntity.ok(this.productCatalogService.updateProductSpecification(Long.parseLong(id),formInfo));
    }

    @GetMapping("/productSpecification/cancel/{id}")
    private ResponseEntity<String> cancelProductSpecification(@PathVariable @NonNull String id){
        this.productCatalogService.cancelProductSpecification(Long.parseLong(id));
        return ResponseEntity.ok(Contants.ResponseMessage.CANCELLED);
    }

    @GetMapping("/productSpecification/activate/{id}")
    private ResponseEntity<String> activateProductSpecification(@PathVariable @NonNull String id){
        this.productCatalogService.activateProductSpecification(Long.parseLong(id));
        return ResponseEntity.ok(Contants.ResponseMessage.CANCELLED);
    }

    @DeleteMapping("/productSpecification/{id}")
    private ResponseEntity<Void> deleteProductSpecification(@PathVariable @NonNull String id){
        this.productCatalogService.deleteProductSpecification(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/productSpecification/{id}")
    private ResponseEntity<ProductSpecification> getProductSpecification(@PathVariable @NonNull String id){
        return ResponseEntity.ok(this.productCatalogService.getProductSpecification(Long.parseLong(id)));
    }

}
