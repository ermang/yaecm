package com.eg.yaecm.product.service;

import com.eg.yaecm.common.YaecmException;
import com.eg.yaecm.product.entity.Product;
import com.eg.yaecm.product.repo.ProductRepo;
import com.eg.yaecm.product.servicereq.CreateProductServiceReq;
import com.eg.yaecm.product.serviceresp.ReadProductServiceResp;
import com.eg.yaecm.product.util.Entity2ServiceResp;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final Entity2ServiceResp entity2ServiceResp;
    private final ProductRepo productRepo;

    public ProductService(Entity2ServiceResp entity2ServiceResp, ProductRepo productRepo) {
        this.entity2ServiceResp = entity2ServiceResp;
        this.productRepo = productRepo;
    }

    public void createProduct(CreateProductServiceReq serviceReq) {
        Product p = new Product();

        p.setName(serviceReq.name);
        p.setDescr(serviceReq.description);
        p.setPrice(serviceReq.price);

        productRepo.save(p);
    }

    public ReadProductServiceResp getProduct(long id) {

        Optional<Product> optionalP = productRepo.findById(id);

        if (optionalP.isEmpty())
            throw new YaecmException("");

        Product p = optionalP.get();
        ReadProductServiceResp serviceResp = entity2ServiceResp.product2ReadProductServiceResp(p);

        return serviceResp;
    }
}
