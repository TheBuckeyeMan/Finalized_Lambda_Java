package com.example.lambdatemplate.service;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class MessRound {

    private static final Logger log = LoggerFactory.getLogger(MessRound.class);

    public void yessir(){
        System.out.println("No SIR");
        log.info("Whats going on from Idaho");
    }
    public void nossir(int number){
        if (number > 5){
            log.info("Number is grreater than 5");
        } else {
            log.info("Number is less than 5");
        } 
       
    }    
}
