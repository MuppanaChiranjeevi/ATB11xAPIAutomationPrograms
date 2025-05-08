package com.thetestingacademy.Ex02_Basics;

import io.restassured.RestAssured;

public class Lab05_APITesting_Multiple_TestCases {
    public static void main(String[] args) {

        String pincode = "110048";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
        System.out.println("------------------------------------");
        pincode = "@";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
        System.out.println("------------------------------------");
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
