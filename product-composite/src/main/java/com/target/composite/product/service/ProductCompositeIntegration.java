package com.target.composite.product.service;


import com.target.composite.product.client.ProductInfoClient;
import com.target.composite.product.client.ProductPriceClient;
import com.target.composite.product.client.dto.ProductInfo;
import com.target.composite.product.client.dto.ProductPrice;
import com.target.composite.product.model.MonetaryAmount;
import com.target.composite.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


@Service
public class ProductCompositeIntegration implements ProductCompositeService{

    private final ProductInfoClient infoClient;
    private final ProductPriceClient priceClient;
    @Autowired
    public ProductCompositeIntegration(ProductInfoClient infoClient,ProductPriceClient priceClient){
        this.infoClient = infoClient;
        this.priceClient = priceClient;
    }

    @Cacheable(value = "productComposite")
    @Override
    public Product getProduct(long productId) {
        ProductInfo info = getProductInfo(productId);
        ProductPrice price = getProductPrice(productId);
        return createProduct(productId, info, price);
    }

    private ProductInfo getProductInfo(long productId) {
        return infoClient.getProductInfo(productId);

    }

    private ProductPrice getProductPrice(long productId) {
        return priceClient.getProductPrice(productId);
    }
    private Product createProduct(long productId, ProductInfo info, ProductPrice price){
        String productName= info == null ? null :info.getName();
        MonetaryAmount currentPrice = price == null? null : createPrice(price.getCurrent_price());
        return new Product(productId, productName, currentPrice);

    }
    private MonetaryAmount createPrice(com.target.composite.product.client.dto.MonetaryAmount amount){
        return amount == null ? null :
                new MonetaryAmount(amount.getCurrency_code(), amount.getValue());
    }


}
