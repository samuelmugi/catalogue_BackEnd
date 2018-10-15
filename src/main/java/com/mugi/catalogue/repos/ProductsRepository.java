/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.repos;

import com.mugi.catalogue.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author @SaQlever
 */
public interface ProductsRepository extends JpaRepository<Products, Long> {

 
    @Query("SELECT p FROM Products p  WHERE lower(p.prodName) LIKE CONCAT('%',:searchParams,'%')  ")
    public Page<Products> findSearchProducts(@Param("searchParams")String searchParams, Pageable pageable);
    
}
