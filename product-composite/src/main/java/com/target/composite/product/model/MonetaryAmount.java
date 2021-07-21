package com.target.composite.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonetaryAmount implements Serializable {
    private  String currency_code;
    private  BigDecimal value;
}
