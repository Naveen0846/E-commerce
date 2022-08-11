package org.shopping.controller;

import org.shopping.dto.ProductResponseDto;
import org.shopping.entity.ProductType;
import org.shopping.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductDetailsController {

	@Autowired
	private ProductDetailsService productService;

	@PostMapping("/type/save")
	public ResponseEntity<ProductType> saveProductsType(@RequestBody ProductType productType) {
		ProductType response = productService.saveProductType(productType);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/details")
	public ResponseEntity<ProductResponseDto> getProductDetails(@RequestParam("productType") String productType) {
		ProductResponseDto response = productService.getDetails(productType);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
