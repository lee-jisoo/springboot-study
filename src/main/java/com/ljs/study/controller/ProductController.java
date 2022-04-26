package com.ljs.study.controller;


import com.ljs.study.component.PriceComponent;
import com.ljs.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @Autowired
    public PriceComponent priceComponent;

    @GetMapping("all")
    public List<String> getProduct() {
        return productService.getProduct();
    }

    @PostMapping("insert")
    public String insertProduct(@RequestParam("productName") String productName) {
        productService.insertProduct(productName);
        return "OK";
    }

    @GetMapping("btcPrice")
    public BigDecimal getPrice() {
        return priceComponent.getPrice("BTC");
    }

}
