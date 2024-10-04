package com.example.lambdatemplate.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.lambdatemplate.api.model.Model;

@Service
public class ExternalApiCall {

    RestTemplate restTemplate = new RestTemplate();
    private static final Logger log = LoggerFactory.getLogger(ExternalApiCall.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ExternalApiCall(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Object getFact() throws JsonMappingException, JsonProcessingException{
        String url = "https://catfact.ninja/fact?max_length=140";
        Object result = null;
        try{
            log.info("Request made to external API: " + restTemplate.getForObject(url, String.class)); //Check the outbound API Request
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            if (jsonNode.isArray()){ //Get Response if List
                result = objectMapper.readValue(jsonResponse, new TypeReference<List<Model>>() {});
                log.info("Response is a List: " + result);
                log.info("Response Recieved from API: " + jsonResponse);
            } else if (jsonNode.isObject()){ //Get response if Object
                result = objectMapper.readValue(jsonResponse, Model.class);
                log.info("Response is an Object: " + result);
                log.info("Response Recieved from API: " + jsonResponse);
            }
        } catch (HttpStatusCodeException e) {
            log.error("Recieved Error from API", e.getResponseBodyAsString(), e);
        }
        return result;
    } 
}