package org.shopping.controller;

import java.util.List;

import org.shopping.dto.CustomerDto;
import org.shopping.entity.EngineDetails;
import org.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shop")
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;

	@PostMapping(value = "/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto) {
		String createCustomer = shoppingService.createCustomer(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createCustomer);
	}

	@GetMapping(value = "/cust/{region}")
	public ResponseEntity<List<EngineDetails>> getDetailsByRegion(@PathVariable("region") String region) {
		List<EngineDetails> details = shoppingService.findByRegion(region);
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}

	@PutMapping(value = "/getCust/{customerId}")
	public String getFinalPrice(@PathVariable("customerId") Integer customerId) {
		float details = shoppingService.findCustomer(customerId);
		return "Details of Customer is: " + details;
	}
}
