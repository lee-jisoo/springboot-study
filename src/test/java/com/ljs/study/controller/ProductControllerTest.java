package com.ljs.study.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Order(2)
    @DisplayName("[GET] /product/all")
    @Test
    public void getProduct() throws Exception {
        // then
        mvc.perform(get(("/product/all")))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"아이패드\"]"))
                .andDo(print());
    }

    @Order(1)
    @DisplayName("[POST] /product/insert")
    @Test
    public void insertProduct() throws Exception {
        mvc.perform(post(("/product/insert"))
                .param("productName", "아이패드"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"))
                .andDo(print());
    }

    @DisplayName("[POST] /product/insert (파라메터 없는 경우 에러케이스)")
    @Test
    public void insertProduct2() throws Exception {
        mvc.perform(post(("/product/insert")))
                .andExpect(status().isBadRequest()) // 400 에러 검증
                .andDo(print());
    }

}
