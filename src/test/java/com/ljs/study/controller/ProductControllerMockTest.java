package com.ljs.study.controller;

import com.ljs.study.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Controller 만 MockTest
@WebMvcTest(ProductController.class)
public class ProductControllerMockTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @DisplayName("[GET] /product/all")
    @Test
    public void getProduct() throws Exception {
        final List<String> list = List.of("갤럭시");

        when(productService.getProduct()).thenReturn(list);

        mvc.perform(get(("/product/all")))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"갤럭시\"]"))
                .andDo(print());
    }

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
