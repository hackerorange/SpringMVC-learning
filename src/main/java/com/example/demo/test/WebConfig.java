package com.example.demo.test;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter stringHttpMessageConverter =new MyStringMessageConverter() ;
        converters.add(stringHttpMessageConverter);

        super.configureMessageConverters(converters);
    }

//      @Bean
//    public HttpMessageConverter stringHttpMessageConverter() {
//        return new MyStringMessageConverter();
//    }


}