package com.example.demo.test;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyStringMessageConverter extends FastJsonHttpMessageConverter {

    private final StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(UTF_8);

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void write(Object t, Type type, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (t instanceof String) {
            String t1 = (String) t;
            stringHttpMessageConverter.write(t1, contentType, outputMessage);
            return;
        }
        super.write(t, type, contentType, outputMessage);
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {


        super.writeInternal(obj, outputMessage);
    }
}
