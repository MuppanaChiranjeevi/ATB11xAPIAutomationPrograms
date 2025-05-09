package com.thetestingacademy.Ex01_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Lab02_APITesting_RA {
    public static void main(String[] args) {
        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD

        // Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // bath Path - /IN/560066
        System.out.print("Enter the pincode:");
        Scanner sc=new Scanner(System.in);
        String pincode= sc.next();
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pincode)
                    .when()
                        .get()
                    .then()
                        .log().all().statusCode(200);

        // Headers, Cookies, Response Body, ...others.
    }
}
/*
Full Breakdown of the Request:
RestAssured.given() — Initializes the request and prepares the environment for the setup.

.baseUri("https://api.zippopotam.us") — Specifies the base URL (https://api.zippopotam.us), which is common to all requests for the Zippopotam API.

.basePath("/IN/" + pincode) — Appends the path for a specific endpoint. This uses the IN (India) country code and a dynamic pincode to construct the full path.

.when() — Indicates that the next action will be to make the HTTP request.

.get() — Sends the GET request to the constructed URL (https://api.zippopotam.us/IN/{pincode}).

.then() — Marks the start of response validation.

.log().all() — Logs all details of the request and the response for inspection.

.statusCode(200) — Asserts that the HTTP response status code should be 200, meaning the request was successful.


 */
