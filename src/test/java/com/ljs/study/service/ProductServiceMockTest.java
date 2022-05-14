package com.ljs.study.service;

import com.ljs.study.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void getProduct() {
        // given (stub 처리, 테스트를 위한 데이터 준비)
        final List<String> mockResult = Lists.newArrayList();
        mockResult.add("갤럭시");
        when(productRepository.getProduct()).thenReturn(mockResult);

        //when (테스트 수행)
        final List<String> results = productService.getProduct();

        // then (검증)
        assertThat(results).isNotNull();
        assertThat(results).isNotEmpty();
        assertThat(results).hasSize(1);
        assertEquals(mockResult, results);
    }

    @Test
    void insertProduct() {
        // given (stub 처리, 테스트를 위한 데이터 준비)
        final String product = "헬로우";

        //when (테스트 수행)
        productService.insertProduct(product);

        // then (검증)
        verify(productRepository, times(1)).insertProduct(product);
    }
}