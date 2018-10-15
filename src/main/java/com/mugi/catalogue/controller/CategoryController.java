/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mugi.catalogue.controller;

import com.mugi.catalogue.entity.Category;
import com.mugi.catalogue.services.CategoryService;
import com.mugi.catalogue.utils.RestRequestObject;
import com.mugi.catalogue.utils.RestResponse;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/CATALOGUE/Category")
    @Api(value = "Transactions management", description = "Transactions management API")
    public class CategoryController {

        @Autowired
        CategoryService categoryService;
         
     
    /*--------------------------createOutgoingMessage---------------------*/
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {"application/json",
        "application/xml"}, produces = {"application/json", "application/xml"})
    @ApiOperation(value = " create Category", notes = "create Category")
    public RestResponse createOutgoingMessageMapping(@RequestBody RestRequestObject<Category> req,
            HttpServletRequest request, HttpServletResponse response) {
         RestResponse  resp = new RestResponse(categoryService.createCategory(req), HttpStatus.OK);
        
        return resp;
    }
    
        /*-------------------------- List all   Transactions API ---------------------*/
        @RequestMapping(value = "/listAll", method = RequestMethod.POST, consumes = {"application/json",
            "application/xml"}, produces = {"application/json", "application/xml"})
        @ApiOperation(value = "Get a  list of all   Category", notes = "The json list of categories")
        public RestResponse listOutgoingMessageMapping(@SuppressWarnings("rawtypes") @RequestBody RestRequestObject req,
                 HttpServletRequest request, HttpServletResponse response) {
                   RestResponse  resp = new RestResponse(categoryService.listCategory(), HttpStatus.OK);

            return resp;
        }

}
