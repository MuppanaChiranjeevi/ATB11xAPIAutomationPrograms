package com.thetestingacademy.Ex04_RA_HTTPMethods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab08_APITesting_GET_BDD {
    String pincode;
    @Test
    public void test_GET_BDD_POSITIVE_TC1(){
        pincode = "388620";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }
    @Test
    public void test_GET_BDD_NEGATIVE_TC2(){
        pincode = "100";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(404);
    }
}
