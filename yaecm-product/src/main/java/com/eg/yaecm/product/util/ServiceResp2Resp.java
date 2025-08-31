package com.eg.yaecm.product.util;

import com.eg.yaecm.product.entity.Product;
import com.eg.yaecm.product.resp.ReadProductResp;
import com.eg.yaecm.product.serviceresp.ReadProductServiceResp;
import org.springframework.stereotype.Component;

@Component
public class ServiceResp2Resp {

    public ReadProductResp readProductServiceResp2ReadProductResp(ReadProductServiceResp serviceResp) {
        ReadProductResp resp = new ReadProductResp(serviceResp.id, serviceResp.name, serviceResp.description, serviceResp.price);

        return resp;
    }
}
