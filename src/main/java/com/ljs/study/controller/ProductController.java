package com.ljs.study.controller;


import com.ljs.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("all")
    public List<String> getProduct() {
        return productService.getProduct();
    }

    @PostMapping("insert")
    public String insertProduct(@RequestParam("productName") String productName) {
        productService.insertProduct(productName);
        return "OK";
    }

}
