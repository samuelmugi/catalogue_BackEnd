/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.repos;

import com.mugi.catalogue.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author @SaQlever
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
