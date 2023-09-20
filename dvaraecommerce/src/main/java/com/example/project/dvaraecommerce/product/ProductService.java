package com.example.project.dvaraecommerce.product;

import com.example.project.dvaraecommerce.exception.ProductNotFoundException;

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
                .orElseThrow(() -> new ProductNotFoundException("No book found with the id : " + productId)));
    }

    @Override
    public void delete(Long productId) {
        Optional<Product> theBook = findById(productId);
        theBook.ifPresent(book ->productRepository.deleteById(book.getId()));
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
