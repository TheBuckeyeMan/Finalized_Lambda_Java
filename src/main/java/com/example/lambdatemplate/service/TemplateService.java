package com.example.lambdatemplate.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.lambdatemplate.api.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.function.Supplier;

//Entire purpose of service is to consume the data from api
@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService implements Supplier<List<Model>>{
    
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();//Add in object for the JSON Response Object

    public List<Model> get(){
        String url = "<Your URL Here>";

        List<Model> model = null;
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            model = objectMapper.readValue(jsonResponse, new TypeReference<List<Model>>() {});

            log.info("Recieved JSON Response from external API: {}", jsonResponse);//Log the JSON Response from Extenral API
                if (model != null) {
                    log.info("Model Successful Build!");
                }
                } catch (HttpStatusCodeException e) {
                    log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);//log error if an error status code is returned
                } catch (Exception e) {
                    log.error("An Error Occured while making the reques tto external API: {}", e);
                }
       return model;
    }
}