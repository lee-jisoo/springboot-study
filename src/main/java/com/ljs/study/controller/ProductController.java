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
    public PriceComponent bithumPriceComponent;

    @Autowired
    public PriceComponent upbitPriceComponent;

    @GetMapping("all")
    public List<String> getProduct() {
        return productService.getProduct();
    }

    @PostMapping("insert")
    public String insertProduct(@RequestParam("productName") String productName) {
        productService.insertProduct(productName);
        return "OK";
    }

    /**
     * 요구사항이 바뀌어서 빗썸과 업비트의 평균가를 내려줘야 한다.
     */
    @GetMapping("btcPrice")
    public BigDecimal getPrice() {
        BigDecimal bithumPrice = bithumPriceComponent.getPrice("BTC");
        BigDecimal upbitPrice = upbitPriceComponent.getPrice("BTC");
        BigDecimal avgPrice = bithumPrice.add(upbitPrice).divide(BigDecimal.valueOf(2));
        return avgPrice;
    }

}
