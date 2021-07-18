package com.target.mock.productprice.service;

import com.target.mock.productinfo.data.ProductPrice;
import com.target.mock.productprice.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoProductPriceService implements ProductPriceService{
    ProductPriceRepository priceRepository;
    @Autowired
    MongoProductPriceService(ProductPriceRepository repo){
        this.priceRepository = repo;
    }

    @Override
    public Optional<ProductPrice> getProductPrice(long productId) {
        return  priceRepository.findById(productId);
    }
}
