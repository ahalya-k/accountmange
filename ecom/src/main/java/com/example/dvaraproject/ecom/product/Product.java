package com.example.dvaraproject.ecom.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
   
    private UUID isbn = UUID.randomUUID();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public UUID getIsbn() {
		return isbn;
	}

	public void setIsbn(UUID isbn) {
		this.isbn = isbn;
	}

	public Product(Long id, String name, Double price, UUID isbn) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isbn = isbn;
	}

	public Product() {
		
	}
    
}