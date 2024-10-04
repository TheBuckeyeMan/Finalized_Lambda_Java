package com.example.lambdatemplate.api.Handler;

import org.springframework.web.client.RestTemplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambdatemplate.service.ExternalApiCall;
import com.example.lambdatemplate.service.MessRound;
import com.fasterxml.jackson.core.JsonProcessingException;

public class LambdaHandler implements RequestHandler<Object, Object> {
    private MessRound messRound;
    private ExternalApiCall externalApiCall;

    public LambdaHandler() {
        messRound = new MessRound();
        RestTemplate restTemplate = new RestTemplate();
        externalApiCall = new ExternalApiCall(restTemplate); 
    }

    @Override
    public Object handleRequest(final Object input, final Context context) {
        try{
            messRound.yessir();
            externalApiCall.getFact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "API Successfully Triggered - Success";
    }
}
