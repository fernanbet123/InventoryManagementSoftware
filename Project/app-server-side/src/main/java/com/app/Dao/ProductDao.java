package com.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
