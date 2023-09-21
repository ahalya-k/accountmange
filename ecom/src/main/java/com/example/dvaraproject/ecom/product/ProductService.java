package com.example.dvaraproject.ecom.product;

import com.example.dvaraproject.ecom.exception.ProductNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service

public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    
    public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return Optional.ofNullable(productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("No product found with the id : " + productId)));
    }

    @Override
    public void delete(Long productId) {
        Optional<Product> theProduct = findById(productId);
        theProduct.ifPresent(product ->productRepository.deleteById(product.getId()));
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
