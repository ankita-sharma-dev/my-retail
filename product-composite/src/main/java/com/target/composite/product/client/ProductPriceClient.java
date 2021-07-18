package com.target.composite.product.client;

import com.target.composite.product.client.dto.ProductPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductPriceClient", url = "${product.price.service.base.url}")
public interface ProductPriceClient {
    @GetMapping(value = "/products/{productId}/prices/current")
    ProductPrice getProductPrice(@PathVariable("") long productId);
}
