package com.example.lambdatemplate;

import org.springframework.web.client.RestTemplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambdatemplate.service.MessRound;
import com.example.lambdatemplate.service.TemplateService;

import software.amazon.awssdk.services.s3.S3AsyncClient;


/**
 * Lambda function entry point. You can change to use other pojo type or implement
 * a different RequestHandler.
 *
 * @see <a href=https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html>Lambda Java Handler</a> for more information
 */
public class App implements RequestHandler<Object, Object> {
    private final S3AsyncClient s3Client;
    private TemplateService templateService;
    private MessRound messRound;


    public App() {
        // Initialize the SDK client outside of the handler method so that it can be reused for subsequent invocations.
        // It is initialized when the class is loaded.
        s3Client = DependencyFactory.s3Client();
        // Consider invoking a simple api here to pre-warm up the application, eg: dynamodb#listTables
        messRound = new MessRound();
        RestTemplate restTemplate = new RestTemplate();
        templateService = new TemplateService(restTemplate);
    }

    @Override
    public Object handleRequest(final Object input, final Context context) {
        messRound.yessir();
        templateService.get();
        // TODO: invoking the api call using s3Client.
        return "Success";
    }
}
