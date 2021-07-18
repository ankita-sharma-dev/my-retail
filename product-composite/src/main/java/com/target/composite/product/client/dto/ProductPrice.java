package com.target.composite.product.client.dto;

import com.target.composite.product.client.dto.MonetaryAmount;
import lombok.Data;

@Data
public class ProductPrice {
    private final long id;
    private final MonetaryAmount current_price;
}
