package com.scaler.novprojectmodule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SampleTesting {

    @Test
    void testAddMethod() {

        int x = 1+2;

//        assert x == 3;

        assertEquals(2,x);


    }

    @Test
    void testSubtractMethod() {

        int x = 2-1;

        assert x == 1;



    }
}

/*

AAA
Arrange : Create the input params
Act     : Call the required function
Assert  : Check the function response wrt to expected value (hardcoded)
 */
