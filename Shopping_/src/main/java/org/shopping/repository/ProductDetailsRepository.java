package org.shopping.repository;

import java.util.List;

import org.shopping.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{

	List<ProductDetails> findByType(String productType);

}
