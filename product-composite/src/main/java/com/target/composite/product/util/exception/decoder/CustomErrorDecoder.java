package com.target.composite.product.util.exception.decoder;

import com.target.composite.product.util.exception.ProductErrorCode;
import com.target.composite.product.util.exception.ProductException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder  implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 404:
                return new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND);
            default:
                return new ProductException(ProductErrorCode.PRODUCT_GENERIC);
        }
    }
}
