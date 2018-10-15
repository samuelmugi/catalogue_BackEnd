/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.services;

import com.mugi.catalogue.entity.Category;
import com.mugi.catalogue.repos.CategoryRepository;
import com.mugi.catalogue.utils.RestRequestObject;
import com.mugi.catalogue.utils.RestResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author @SaQlever
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public RestResponseObject createCategory(RestRequestObject<Category> req) {

        RestResponseObject resp = new RestResponseObject();
        resp.setMessage("Error creating Category");
        resp.setPayload(null);
        resp.setRequestStatus(false);
        Category categoryObject = req.getObject();
        try {

            Category categoryNew = new Category();
            int catID = (categoryObject.getCatId() == null || categoryObject.getCatId().toString().length() == 0) ? (categoryRepository.findAll().size()+1) : categoryObject.getCatId();
            categoryNew.setCatId(catID);
            categoryNew.setCatName(categoryObject.getCatName());
            Category createdCategory = categoryRepository.save(categoryNew);
            resp.setMessage("Category Saved Successfully");
            resp.setPayload(createdCategory);
            resp.setRequestStatus(true);

        } catch (Exception er) {
            resp.setMessage("Error creating Category");
            log.error("Sorry Category Save Error \n." + er.toString());
            resp.setRequestStatus(true);

        }
        return resp;
    }

    /*--------------------- listCategory -------------------------*/
    public RestResponseObject listCategory() {
        RestResponseObject resp = new RestResponseObject();
        resp.setMessage("Error listing Category");
        resp.setRequestStatus(false);
        resp.setPayload(null);

        try {
            resp.setPayload(categoryRepository.findAll());
            resp.setRequestStatus(true);
            resp.setMessage("Success");
        } catch (Exception er) {
            log.error(" list Category ERROR:- " + er.getLocalizedMessage());
            resp.setMessage("Error listing Category");
        }
        return resp;
    }
}
