package com.eg.yaecm.product.resp;

import java.math.BigDecimal;

public class ReadProductResp {
    public final long id;
    public final String name;
    public final String description;
    public final BigDecimal price;

    public ReadProductResp(long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
