package com.eg.yaecm.product.util;

import com.eg.yaecm.product.entity.Product;
import com.eg.yaecm.product.req.CreateProductReq;
import com.eg.yaecm.product.servicereq.CreateProductServiceReq;
import com.eg.yaecm.product.serviceresp.ReadProductServiceResp;
import org.springframework.stereotype.Component;

@Component
public class Entity2ServiceResp {

    public ReadProductServiceResp product2ReadProductServiceResp(Product p) {
        ReadProductServiceResp serviceResp = new ReadProductServiceResp(p.getId(), p.getName(), p.getDescr(), p.getPrice());

        return serviceResp;
    }
}
