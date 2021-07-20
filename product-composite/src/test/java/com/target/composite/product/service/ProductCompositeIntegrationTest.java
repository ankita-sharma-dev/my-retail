package com.target.composite.product.service;

import com.target.composite.product.client.ProductInfoClient;
import com.target.composite.product.client.ProductPriceClient;
import com.target.composite.product.client.dto.MonetaryAmount;
import com.target.composite.product.client.dto.ProductInfo;
import com.target.composite.product.client.dto.ProductPrice;
import com.target.composite.product.model.Product;
import com.target.composite.product.util.exception.ProductException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static com.target.composite.product.util.exception.ProductErrorCode.PRODUCT_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class ProductCompositeIntegrationTest {
    private static final long PRODUCT_ID_OK = 1L;
    private static final int PRODUCT_ID_NOT_FOUND = 2;
    @InjectMocks
    ProductCompositeIntegration productService;
    @Mock
    ProductInfoClient infoClient;
    @Mock
    ProductPriceClient priceClient;


    @Test
    public void getProductTest(){
        when(infoClient.getProductInfo(PRODUCT_ID_OK))
                .thenReturn(new ProductInfo(PRODUCT_ID_OK, "mock-name"));
        when(priceClient.getProductPrice(PRODUCT_ID_OK))
                .thenReturn(new ProductPrice(PRODUCT_ID_OK, new MonetaryAmount("USD", new BigDecimal(100.00))));

        Product product = productService.getProduct(PRODUCT_ID_OK);
        assertEquals(product.getId(), PRODUCT_ID_OK);
        assertEquals(product.getName(), "mock-name");

    }

    @Test
    public void productNotFoundTest(){
        when(infoClient.getProductInfo(PRODUCT_ID_NOT_FOUND))
                .thenReturn(new ProductInfo(PRODUCT_ID_OK, "mock-name"));
        when(priceClient.getProductPrice(PRODUCT_ID_NOT_FOUND))
                .thenThrow(new ProductException(PRODUCT_NOT_FOUND));
        assertThrows( ProductException.class,()-> productService.getProduct(PRODUCT_ID_NOT_FOUND));


    }

}
