package com.target.mock.productinfo.controller;

import com.target.mock.productinfo.model.ProductInfo;
import com.target.mock.productinfo.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v2/pdp/tcin")
public class ProductInfoController {
    private ProductInfoService productInfoService;

    @Autowired
    ProductInfoController(ProductInfoService service){
        this.productInfoService = service;
    }

    @GetMapping( value = "/{productId}")
    public ProductInfo getProductInfo(@PathVariable("productId") long productId){
        Optional<ProductInfo> prodInfo = productInfoService.findProductInfoById(productId);
        if(prodInfo.isPresent()){
            return prodInfo.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
