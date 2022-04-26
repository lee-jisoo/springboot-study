package com.ljs.study.component;

import java.math.BigDecimal;

public class PriceComponent {

    public String GET_PRICE_API;

    public PriceComponent (String api) {
        this.GET_PRICE_API = api;
    }

    public BigDecimal getPrice(String market) {
        // 실제로는 API를 쏘고 응답을 받아서 리턴을 주겠지

        // CALL API
        // RestTemplate restTemplate = new RestTemplate();
        // String ressponse = restTemplate.getForObject(GET_API, String.class);

        return BigDecimal.ONE;
    }

}
