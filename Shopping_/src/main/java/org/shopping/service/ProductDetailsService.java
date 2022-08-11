package org.shopping.service;

import org.shopping.dto.ProductResponseDto;
import org.shopping.entity.ProductType;

public interface ProductDetailsService {

	ProductType saveProductType(ProductType productType);

	ProductResponseDto getDetails(String productType);

}
