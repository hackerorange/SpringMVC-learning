package com.example.demo.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Random;

@ControllerAdvice
public class RequestBodyTest implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        return body;
        HttpHeaders headers = request.getHeaders();
        HttpHeaders responseHeaders = response.getHeaders();
        if (headers.containsKey("encrypt")) {
            responseHeaders.add("Content-Type", "text/plain; charset=utf-8");
            Random random = new Random();
            Integer mySeed = random.nextInt(100000);
            responseHeaders.add("seed", String.valueOf(mySeed));
            return Base64Utils.encodeToString(JSONObject.toJSONString(body).getBytes());
        } else {
            responseHeaders.add("Content-Type", "text/json; charset=utf-8");
            return body;
        }
    }
}
