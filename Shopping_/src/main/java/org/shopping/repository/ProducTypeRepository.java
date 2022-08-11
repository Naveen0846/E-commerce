package org.shopping.repository;

import java.util.Optional;

import org.shopping.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducTypeRepository extends JpaRepository<ProductType, Integer> {

	@Query(value = "select * from product_type where type=:productType", nativeQuery = true)
	Optional<ProductType> getProductTypeDetails(String productType);

}
