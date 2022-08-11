package org.shopping.service;

import java.util.List;

import org.shopping.dto.CustomerDto;
import org.shopping.entity.EngineDetails;

public interface ShoppingService {

	String createCustomer(CustomerDto customerDto);

	float findCustomer(Integer customerId);

	List<EngineDetails> findByRegion(String region);

}
