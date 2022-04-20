package com.ljs.study.service;

import com.ljs.study.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<String> getProduct() {
        return productRepository.getProduct();
    }

    public void insertProduct(String product) {
        productRepository.insertProduct(product);
    }

}
