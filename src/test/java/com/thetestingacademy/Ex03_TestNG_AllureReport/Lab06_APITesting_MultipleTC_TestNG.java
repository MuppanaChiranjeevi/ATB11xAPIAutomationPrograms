package com.thetestingacademy.Ex03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab06_APITesting_MultipleTC_TestNG {
        String pincode;
        @Test
        public void test_GET_POSITIVE_TC1(){
        pincode = "110048";
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
        public void test_GET_POSITIVE_TC2(){
        pincode = "560069";
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
        public void test_GET_NEGATIVE_TC3(){
        pincode = "@";
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
        public void test_GET_NEGATIVE_TC4(){
        pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/USA/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

}
