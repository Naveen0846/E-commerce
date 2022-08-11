package org.shopping.repository;

import java.util.List;

import org.shopping.entity.EngineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends JpaRepository<EngineDetails, Integer> {

	List<EngineDetails> findByRegion(String region);

}
