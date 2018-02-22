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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;
@Entity
@Table(name="Category_tb")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;
	private String name;
	private String description;
	
	private Set<Product> products;
	private Set<Brand> brands;
	public Category() {
		super();
	}
	public Category(Long id, String name, String description, Set<Product> products, Set<Brand> brands) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.products = products;
		this.brands = brands;
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
	@Column
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	@Column
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Product> getProducts() {
		return products;
	}
	@OneToMany
	@JoinColumn(name="Product_id")
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Set<Brand> getBrands() {
		return brands;
	}
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Category_Brand", joinColumns= {@JoinColumn(name="category_id")}, inverseJoinColumns= {@JoinColumn(name = "brand_id")})
	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}
	
}
