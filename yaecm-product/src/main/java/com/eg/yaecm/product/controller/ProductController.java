package com.eg.yaecm.product.controller;

import com.eg.yaecm.product.req.CreateProductReq;
import com.eg.yaecm.product.service.ProductService;
import com.eg.yaecm.product.util.CreateProductServiceReq;
import com.eg.yaecm.product.util.Req2ServiceReq;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final Req2ServiceReq req2ServiceReq;
    private final ProductService productService;

    public ProductController(Req2ServiceReq req2ServiceReq, ProductService productService) {
        this.req2ServiceReq = req2ServiceReq;
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@RequestBody CreateProductReq req){
        CreateProductServiceReq serviceReq = req2ServiceReq.createProductReq2CreateProductServiceReq(req);
        productService.createProduct(serviceReq);
    }

    @GetMapping
    public void getProduct(){
        //CreateProductServiceReq serviceReq = req2ServiceReq.createProductReq2CreateProductServiceReq(req);
        //productService.getProduct();
    }
}
