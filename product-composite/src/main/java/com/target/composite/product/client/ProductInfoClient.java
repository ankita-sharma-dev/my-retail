package com.target.composite.product.client;

import com.target.composite.product.client.dto.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "ProductInfoClient", url = "${product.info.service.base.url}")
public interface ProductInfoClient {
    @GetMapping(value = "/v2/pdp/tcin/{productId}")
    ProductInfo getProductInfo(@PathVariable("") long productId);
}
