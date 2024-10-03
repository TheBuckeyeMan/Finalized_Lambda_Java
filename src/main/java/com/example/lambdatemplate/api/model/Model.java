package com.example.lambdatemplate.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//entire purpose of the model is to map what we believe the response will be
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    //Add all values we expect to see in the response and data types
    private String fact;
}