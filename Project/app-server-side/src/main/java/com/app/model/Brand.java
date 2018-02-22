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

@Entity
@Table(name="Brand_tb")
public class Brand implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="brand_id")
	private Long id;
	private String name;
	
	
	private Set<Category> categories;
	private Set<Product> products;
	public Brand() {
		super();
	}
	public Brand(Long id, String name, Set<Category> categories, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.products = products;
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
	public Set<Category> getCategories() {
		return categories;
	}
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Category_Brand", joinColumns = {@JoinColumn(name = "brand_id")}, inverseJoinColumns = {@JoinColumn(name="category_id")})
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public Set<Product> getProducts() {
		return products;
	}
	@Column
	@OneToMany(mappedBy = "brand")
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
