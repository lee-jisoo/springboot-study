package com.ljs.study.component;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// 빗썸 코인 시세를 조회 API 입니다.
@Component
public class UpbitPriceComponent {

    public String GET_PRICE_API = "http://upbit.com/getMarketCurrency";

    public BigDecimal getPrice(String market) {
        // 실제로는 API를 쏘고 응답을 받아서 리턴을 주겠지

        // CALL API
        // RestTemplate restTemplate = new RestTemplate();
        // String ressponse = restTemplate.getForObject(GET_API, String.class);

        return BigDecimal.ONE;
    }

}
