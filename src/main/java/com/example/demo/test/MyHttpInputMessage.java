package com.example.demo.test;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.util.Base64Utils;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyHttpInputMessage implements HttpInputMessage {

    private HttpInputMessage httpInputMessage;

    public MyHttpInputMessage(HttpInputMessage httpInputMessage) {
        this.httpInputMessage = httpInputMessage;
    }

    @Override
    public InputStream getBody() throws IOException {

        HttpHeaders headers = httpInputMessage.getHeaders();
        if (!headers.containsKey("encrypt")) {
            return httpInputMessage.getBody();
        }
        InputStream body = httpInputMessage.getBody();
        String s = StreamUtils.copyToString(body, UTF_8);
        byte[] bytes = Base64Utils.decodeFromString(s);
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public HttpHeaders getHeaders() {
        return httpInputMessage.getHeaders();
    }
}
