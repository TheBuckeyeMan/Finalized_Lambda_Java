package com.example.lambdatemplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambdatemplate.service.MessRound;
import com.example.lambdatemplate.service.TemplateService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class App implements RequestHandler<Object, Object> {
    private MessRound messRound;
    private TemplateService templateService;


    public App() {

        messRound = new MessRound();

        RestTemplate restTemplate = new RestTemplate();
        templateService = new TemplateService(restTemplate);
    }

    @Override
    public Object handleRequest(final Object input, final Context context) {
        templateService.get();
        messRound.yessir();
        messRound.nossir(2);
        return "Success";
    }
}
