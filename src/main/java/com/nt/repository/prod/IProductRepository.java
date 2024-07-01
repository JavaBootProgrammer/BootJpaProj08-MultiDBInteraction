package com.nt.repository.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.prod.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
