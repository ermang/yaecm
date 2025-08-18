package com.eg.yaecm.product.service;

import com.eg.yaecm.product.entity.Product;
import com.eg.yaecm.product.repo.ProductRepo;
import com.eg.yaecm.product.util.CreateProductServiceReq;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void createProduct(CreateProductServiceReq serviceReq) {
        Product p = new Product();

        p.setName(serviceReq.name);
        p.setDescr(serviceReq.description);
        p.setPrice(serviceReq.price);

        productRepo.save(p);
    }
}
