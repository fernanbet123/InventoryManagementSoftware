package com.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Product_tb")
public class Product implements Serializable {
	//properties of the products
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	private String name;
	private String model;
	private String Description;
	private Double price;
	/*constraints to make relationship between tables
	*
	one product belongs to one category*/
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	//one product with specific model belongs to a specific brand
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	//one product belongs to many brands.
	
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String description, Double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
		this.price = price;
		this.category = category;
	}

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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
