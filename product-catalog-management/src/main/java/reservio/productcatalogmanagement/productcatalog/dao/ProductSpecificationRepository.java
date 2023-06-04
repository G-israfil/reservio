package reservio.productcatalogmanagement.productcatalog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservio.productcatalogmanagement.productcatalog.entity.ProductSpecification;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification,Long> {
}
