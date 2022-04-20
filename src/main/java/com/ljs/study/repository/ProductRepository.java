package com.ljs.study.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    // db 대신에 임시로 리시트를 사용합니다.
    List<String> list = new ArrayList<>();

    // 상품 전체 목록 조회
    public List<String> getProduct() {
        return list;
    }

    // 상품등록
    public void insertProduct(String productName) {
        list.add(productName);
    }

}
