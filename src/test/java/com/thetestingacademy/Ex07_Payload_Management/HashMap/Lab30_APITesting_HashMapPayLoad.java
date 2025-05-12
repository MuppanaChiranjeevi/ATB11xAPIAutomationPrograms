package com.thetestingacademy.Ex07_Payload_Management.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab30_APITesting_HashMapPayLoad {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @Test
    public void test_create_booking() {
        // Hashmap -> Key and Value
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Chiranjeevi");
        jsonBodyUsingMap.put("lastname", "Muppana");
        jsonBodyUsingMap.put("totalprice", 369);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String,Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin","2025-01-01");
        bookingDatesMap.put("checkout","2024-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Lunch");
        System.out.println(jsonBodyUsingMap);

        System.out.println("---------------------------------------");

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();


        //TestNG Assertions
        Integer bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        Assert.assertEquals(firstname, "Chiranjeevi");
        Assert.assertEquals(lastname, "Muppana");
        Assert.assertNotNull(bookingId);



    }
}
