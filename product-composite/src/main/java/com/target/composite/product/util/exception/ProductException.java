package com.target.composite.product.util.exception;

import lombok.Getter;

public class ProductException extends RuntimeException{
    @Getter
    private ProductErrorCode errorCode;
    public ProductException(ProductErrorCode errorCode){
        this.errorCode = errorCode;
    }
}
