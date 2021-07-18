package com.target.composite.product.controller;


import com.target.composite.product.model.Product;
import com.target.composite.product.service.ProductCompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = "/products")
public class ProductCompositeController {
    private ProductCompositeService productService;

    @Autowired
    ProductCompositeController(ProductCompositeService service){
        this.productService = service;
    }

    @GetMapping( value = "/{productId}")
    public Product getProduct(@PathVariable("productId") long productId){
        return productService.getProduct(productId);
    }
}
