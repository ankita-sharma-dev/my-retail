package com.target.composite.product.model;

import lombok.Data;

@Data
public class Product {
    private final long id;
    private final String name;
    private final MonetaryAmount current_price;
}
