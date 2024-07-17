package com.ijse.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.product.entity.product;

@Repository
public interface ProductRepository extends JpaRepository<product, Long>{
        //custom queries
}
