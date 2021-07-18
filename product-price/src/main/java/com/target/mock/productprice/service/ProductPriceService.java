package com.target.mock.productprice.service;


import com.target.mock.productinfo.data.ProductPrice;

import java.util.Optional;

public interface ProductPriceService {
    public Optional<ProductPrice> getProductPrice(long productId);




}
