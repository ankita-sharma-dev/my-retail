package com.target.composite.product.controller;

import com.target.composite.product.client.dto.ProductInfo;
import com.target.composite.product.model.MonetaryAmount;
import com.target.composite.product.model.Product;
import com.target.composite.product.service.ProductCompositeService;
import com.target.composite.product.util.exception.ProductErrorCode;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.target.composite.product.util.exception.ProductErrorCode.PRODUCT_NOT_FOUND;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductCompositeController.class)
public class ProductControllerTest {
    private static final long PRODUCT_ID_OK = 1;
    private static final String PRODUCT_ID_BAD_REQUEST = "1AA";
    private static final long PRODUCT_ID_NOT_FOUND = 2;
    @Autowired
    MockMvc mvc;
    @MockBean
    ProductCompositeService service;



    @Test
    public void getProductTest() throws Exception{
        when(service.getProduct(PRODUCT_ID_OK))
                .thenReturn(new Product(PRODUCT_ID_OK
                        ,"mock-name"
                        , new MonetaryAmount("USD", new BigDecimal(100.00))));
        mvc.perform(get("/products/"+PRODUCT_ID_OK))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("mock-name")));

    }
    @Test
    void getProductWithBadRequest() throws Exception {
        mvc.perform(get("/products/"+PRODUCT_ID_BAD_REQUEST))
      .andExpect(status().isBadRequest());
    }
    @Test
    void getProductNotFound() throws Exception {
        when(service.getProduct(PRODUCT_ID_NOT_FOUND))
                .thenThrow(new ProductException(PRODUCT_NOT_FOUND));
        mvc.perform(get("/products/"+PRODUCT_ID_NOT_FOUND))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.Message", is(PRODUCT_NOT_FOUND.getMessage())));
    }
}

