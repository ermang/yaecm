package com.eg.yaecm.product.util;

import com.eg.yaecm.product.req.CreateProductReq;
import com.eg.yaecm.product.servicereq.CreateProductServiceReq;
import org.springframework.stereotype.Component;

@Component
public class Req2ServiceReq {

    public CreateProductServiceReq createProductReq2CreateProductServiceReq(CreateProductReq req) {
        CreateProductServiceReq serviceReq = new CreateProductServiceReq();
        serviceReq.name = req.name;
        serviceReq.description = req.description;
        serviceReq.price = req.price;

        return serviceReq;
    }
}
