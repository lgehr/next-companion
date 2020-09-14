package com.example.hochi.nextcompanion;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test for if the Java Classes can be parsed into JSON and JSON into the Java Classes.
 *
 */
public class JsonMappingTest {

    @Test
    public void mapNextbikeResonseLogin_isCorrect(){
        File response = new File("testdata/loginResponse.json"); //A json reply manually fetched via curl
        ObjectMapper oj = new ObjectMapper();
        NextbikeResponseLogin responseObject = null;
        String json = "Error, json not found";
        try {
            responseObject = oj.readValue(response, NextbikeResponseLogin.class);
            json = oj.writeValueAsString(responseObject);
        } catch(IOException e){
            e.printStackTrace();
            System.exit(2);
        }
        System.out.println(json);
        assertEquals("49123456",  responseObject.getUser().loginkey);
    }
}
