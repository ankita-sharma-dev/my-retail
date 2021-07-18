package com.target.mock.productprice.repository;

import com.target.mock.productinfo.data.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductPriceRepository extends MongoRepository<ProductPrice, Long> {

}
