package com.example.lambdatemplate.api.Interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.stereotype.Component;
import java.io.IOException;

//Add to Request Headers
//If authentication is not required, we can remove this class

@Component
public class ApiKeyInterceptor implements ClientHttpRequestInterceptor{
    private final String apiKey;

    public ApiKeyInterceptor(String apiKey){
        this.apiKey = apiKey;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("<Headder Name>", apiKey);
        return execution.execute(request, body);
    }
}