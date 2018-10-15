/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.controller;

import com.mugi.catalogue.entity.Products;
import com.mugi.catalogue.services.ProductsService;
import com.mugi.catalogue.utils.RestRequestObject;
import com.mugi.catalogue.utils.RestResponse;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author @SaQlever
 */
@RestController
@RequestMapping(value = "/CATALOGUE/Products")
@Api(value = "Transactions management", description = "Transactions management API")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    /*--------------------------createProducts API---------------------*/
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {"application/json",
        "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = " createProducts", notes = "createProducts")
    public RestResponse createProducts(@RequestBody RestRequestObject<Products> req,
            HttpServletRequest request, HttpServletResponse response) {
        RestResponse resp = new RestResponse(productsService.createProducts(req), HttpStatus.OK);

        return resp;
    }

    /*--------------------------searchProducts API---------------------*/
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = {"application/json",
        "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = " createProducts", notes = "createProducts")
    public RestResponse searchProducts(@RequestBody RestRequestObject<Products> req,
            Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
        RestResponse resp = new RestResponse(productsService.searchProducts(req.getSearchParams(), pageable), HttpStatus.OK);

        return resp;
    }

    /*--------------------------listProducts API ---------------------*/
    @RequestMapping(value = "/listAll", method = RequestMethod.POST, consumes = {"application/json",
        "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Get a  list of all   Products", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public RestResponse listProducts(@SuppressWarnings("rawtypes") @RequestBody RestRequestObject req,
            Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
        RestResponse resp = new RestResponse(productsService.listProducts(pageable), HttpStatus.OK);

        return resp;
    }

}
