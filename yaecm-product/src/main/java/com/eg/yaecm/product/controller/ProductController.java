package com.eg.yaecm.product.controller;

import com.eg.yaecm.product.req.CreateProductReq;
import com.eg.yaecm.product.resp.ReadProductResp;
import com.eg.yaecm.product.service.ProductService;
import com.eg.yaecm.product.servicereq.CreateProductServiceReq;
import com.eg.yaecm.product.serviceresp.ReadProductServiceResp;
import com.eg.yaecm.product.util.Req2ServiceReq;
import com.eg.yaecm.product.util.ServiceResp2Resp;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final Req2ServiceReq req2ServiceReq;
    private final ServiceResp2Resp serviceResp2Resp;
    private final ProductService productService;

    public ProductController(Req2ServiceReq req2ServiceReq, ServiceResp2Resp serviceResp2Resp, ProductService productService) {
        this.req2ServiceReq = req2ServiceReq;
        this.serviceResp2Resp = serviceResp2Resp;
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@RequestBody CreateProductReq req){
        CreateProductServiceReq serviceReq = req2ServiceReq.createProductReq2CreateProductServiceReq(req);
        productService.createProduct(serviceReq);
    }

    @GetMapping("/{id}")
    public ReadProductResp getProduct(@PathVariable("id") long id){

        ReadProductServiceResp serviceResp = productService.getProduct(id);
        ReadProductResp resp = serviceResp2Resp.readProductServiceResp2ReadProductResp(serviceResp);

        return resp;
    }
}
