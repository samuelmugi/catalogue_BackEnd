/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.services;

import com.mugi.catalogue.entity.Products;
import com.mugi.catalogue.repos.ProductsRepository;
import com.mugi.catalogue.utils.RestRequestObject;
import com.mugi.catalogue.utils.RestResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author @SaQlever
 */
@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public RestResponseObject createProducts(RestRequestObject<Products> req) {

        RestResponseObject resp = new RestResponseObject();
        resp.setMessage("Error creating Products");
        resp.setPayload(null);
        resp.setRequestStatus(false);
        Products productObject = req.getObject();
        try {

            Products productNew = new Products();
            int prodID = (productObject.getProdId() == null || productObject.getProdId().toString().length() == 0) ? (productsRepository.findAll().size()+1) : productObject.getProdId();
            productNew.setProdId(prodID);
            productNew.setCatId(productObject.getCatId());
            productNew.setProdName(productObject.getProdName());
            Products createdProducts = productsRepository.save(productNew);
            resp.setMessage("Success");
            resp.setPayload(createdProducts);
            resp.setRequestStatus(true);

        } catch (Exception er) {
            resp.setMessage("Error creating Products");
            resp.setRequestStatus(true);
            log.error("Sorry Products Error \n." + er);

        }
        return resp;
    }

    public RestResponseObject searchProducts(String searchParams, Pageable pageable) {
        RestResponseObject resp = new RestResponseObject();
        resp.setMessage("Error search Products ");
        resp.setRequestStatus(false);
        resp.setPayload(null);

        try {
             resp.setPayload(productsRepository.findSearchProducts(searchParams.toLowerCase(), pageable));
            resp.setRequestStatus(true);
            resp.setMessage("Success");
        } catch (Exception er) {
            resp.setMessage("Error search Products ");
            resp.setRequestStatus(false);
            log.error(" searchProducts :- " + er.getLocalizedMessage());

        }
        return resp;
    }

    /*--------------------- List Transactions -------------------------*/
    public RestResponseObject listProducts(Pageable pageable) {
        RestResponseObject resp = new RestResponseObject();
        resp.setMessage("Error listing Products  ");
        resp.setRequestStatus(false);
        resp.setPayload(null);

        try {

            resp.setPayload(productsRepository.findAll(pageable));
            resp.setRequestStatus(true);
            resp.setMessage("Success");
        } catch (Exception er) {
            resp.setMessage("Error listing Products  ");
            resp.setRequestStatus(false);
            log.error(" ERROR:- " + er.getLocalizedMessage());

        }
        return resp;
    }
}
