package reservio.productcatalogmanagement.productcatalog.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productCatalogManagement")
@Slf4j
public class ProductCatalogController {

    @PostMapping("/productSpecification")
    private void createProductSpecification(){

    }
    @PatchMapping("/productSpecification/{id}")
    private void updateProductSpecification(@PathVariable @NonNull String id){

    }

    @DeleteMapping("/productSpecification/{id}")
    private void deleteProductSpecification(@PathVariable @NonNull String id){

    }

    @GetMapping("/productSpecification/{id}")
    private void getProductSpecification(@PathVariable @NonNull String id){

    }

}
