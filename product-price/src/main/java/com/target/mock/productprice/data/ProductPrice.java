package com.target.mock.productinfo.data;

import com.target.mock.productprice.data.MonetaryAmount;
import lombok.Data;

@Data
public class ProductPrice {
    private final long id;
    private final MonetaryAmount current_price;
}
