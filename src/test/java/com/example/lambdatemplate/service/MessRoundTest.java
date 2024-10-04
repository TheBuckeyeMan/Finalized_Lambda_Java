// package com.example.lambdatemplate.service;

// import static org.mockito.Mockito.mock;

// import java.lang.System.Logger;

// import org.junit.jupiter.api.Test;
// import com.example.lambdatemplate.service.MessRound;

// public class MessRoundTest {
    
//     @Test
//     void testNossirWhenNumberIsGreaterThanFive(){
//         Logger mockLogger = mock(Logger.class); //Create mock for Logger

//         //create new instance of MessRound with the mock logger
//         MessRound messRound = new MessRound();

//         @Override
//         protected Logger getLogger(){
//             return mockLogger;
//         };
//         messRound.nossir(6);

//         verify(mockLogger).info("Number is greater than 5");
//     }


// }
