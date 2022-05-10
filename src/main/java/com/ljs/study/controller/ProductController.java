package com.ljs.study.controller;


import com.ljs.study.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    public final ProductService productService;

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
