package org.shopping.repository;

import org.shopping.entity.CaProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaProductRepository extends JpaRepository<CaProducts, Integer>{

}
