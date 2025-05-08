package com.thetestingacademy.Ex04_RA_HTTPMethods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab14_APITesting_PATCH_NONBDD {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_put_non_bdd() {

        String token = "5fc14cf39a3b1d6";
        String bookingid = "21333";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"chiranjeevi\",\n" +
                "    \"lastname\" : \"muppana\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payloadPUT).log().all();

        System.out.println("--------------------------------------------");

        response = requestSpecification.when().log().all().patch();

        System.out.println("--------------------------------------------");
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}
