package com.ljs.study.config;

import com.ljs.study.component.PriceComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 해당 클래스에 @Bean이 있으면 Spring IOC 컨테이너에 등록하여 준다.
public class PriceBeanConfig {

    @Bean("bithumPriceComponent")
    public PriceComponent bithumPriceComponent() {
        return new PriceComponent("http://bithum.com/getPrice");
    }

    @Bean // 값이 없는 경우 메소드명이 bean 이름이 된다.
    public PriceComponent upbitPriceComponent() {
        return new PriceComponent("http://bithum.com/getPrice");
    }

}
