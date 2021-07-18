package com.target.mock.productprice.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MonetaryAmount {
    private final String currency_code;
    private final BigDecimal value;
}
