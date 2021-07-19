package com.target.composite.product.util.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ProductErrorCode {
    PRODUCT_NOT_FOUND(10000, "Product Not Found", HttpStatus.NOT_FOUND),
    PRODUCT_GENERIC(10001, "Some error encountered", HttpStatus.NOT_FOUND);
    @Getter
    private int code;
    @Getter
    private String message;
    @Getter
    private HttpStatus status;

    ProductErrorCode(int code, String message, HttpStatus status){
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
