package org.shopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.shopping.dto.ProductResponseDto;
import org.shopping.entity.CaProducts;
import org.shopping.entity.ProductDetails;
import org.shopping.entity.ProductType;
import org.shopping.entity.ProductTypeCategory;
import org.shopping.exception.ProductDetailsNotFoundException;
import org.shopping.repository.CaProductRepository;
import org.shopping.repository.ProducTypeRepository;
import org.shopping.repository.ProductDetailsRepository;
import org.shopping.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	ProducTypeRepository productTypeRepository;

	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Autowired
	CaProductRepository caProductRepository;

	@Override
	public ProductType saveProductType(ProductType productType) {
		boolean response = validateTypeProduct(productType.getProductTypeCategory().toString());
		if (!response) {
			throw new ProductDetailsNotFoundException("Invalid Product category");
		}
		return productTypeRepository.save(productType);
	}

	private boolean validateTypeProduct(String productType) {
		boolean isProductType = false;
		for (ProductTypeCategory productTypeCategory : ProductTypeCategory.values()) {
			if (productTypeCategory.name().equalsIgnoreCase(productType)) {
				isProductType = true;
				break;
			}
		}
		return isProductType;
	}

	@Override
	public ProductResponseDto getDetails(String productType) {
		List<ProductDetails> productDetailsList = productDetailsRepository.findByType(productType);
		if (productDetailsList == null || productDetailsList.isEmpty()) {
			throw new ProductDetailsNotFoundException("Product Details are Empty");
		}
		validateTypeProduct(productType);
		Optional<ProductType> response = productTypeRepository.getProductTypeDetails(productType);
		for (ProductDetails details : productDetailsList) {
			float finalPrice = details.getPrice() * response.get().getTax();
			CaProducts caProduct = new CaProducts();
			caProduct.setFinalPrice(finalPrice);
			caProduct.setName(details.getName());
			caProduct.setType(productType);
			caProductRepository.save(caProduct);
		}
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setProductDetails(productDetailsList);
		productResponseDto.setProductType(productType);
		return productResponseDto;
	}

}