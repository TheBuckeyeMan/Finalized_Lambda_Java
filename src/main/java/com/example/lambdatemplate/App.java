package com.example.lambdatemplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambdatemplate.service.MessRound;

public class App implements RequestHandler<Object, Object> {
    private MessRound messRound;


    public App() {

        messRound = new MessRound();
    }

    @Override
    public Object handleRequest(final Object input, final Context context) {
        messRound.yessir();
        return "Success";
    }
}
