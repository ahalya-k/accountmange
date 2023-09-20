package com.example.project.dvaraecommerce.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
    private final ProductService productService;
    

    public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/all")
    public ResponseEntity<List<Product>> getAllBooks(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/product/{id}")
    public Optional<Product> getById(@PathVariable("id") Long productId){
        return productService.findById(productId);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        return new ResponseEntity<>(productService.add(product), CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product theProduct){
        return new ResponseEntity<>(productService.update(theProduct), OK);
    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable("id") Long productId){
    	productService.delete(productId);
    }

}