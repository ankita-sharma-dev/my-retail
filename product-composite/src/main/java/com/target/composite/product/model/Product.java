package com.target.composite.product.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private  long id;
    private  String name;
    private  MonetaryAmount current_price;
}
