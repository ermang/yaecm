package com.eg.yaecm.product.serviceresp;

import java.math.BigDecimal;

public class ReadProductServiceResp {
    public final long id;
    public final String name;
    public final String description;
    public final BigDecimal price;

    public ReadProductServiceResp(long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
