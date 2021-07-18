package com.target.mock.productprice.controller;


import com.target.mock.productprice.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.target.mock.productinfo.data.ProductPrice;

import java.util.Optional;

@RestController
@RequestMapping( value = "/products/{productId}")
public class ProductPriceController {
    private ProductPriceService productPriceService;

    @Autowired
    ProductPriceController(ProductPriceService service){

        this.productPriceService = service;
    }

    @GetMapping( value = "/prices/current")
    public ProductPrice getProductPrice(@PathVariable("productId") long productId){
        Optional<ProductPrice> prodPrice = productPriceService.getProductPrice(productId);
        if(prodPrice.isPresent()){
            return prodPrice.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
