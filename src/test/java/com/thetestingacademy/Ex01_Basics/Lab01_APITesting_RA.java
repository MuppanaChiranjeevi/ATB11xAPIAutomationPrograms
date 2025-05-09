package com.thetestingacademy.Ex01_Basics;
/*
Full Breakdown of the Request:
RestAssured.given() — Initializes the request and allows you to configure parameters.

.baseUri("https://restful-booker.herokuapp.com/ping") — Specifies the base URI of the API to which the request is being made.

.when() — Marks the beginning of the request execution phase.

.get() — Executes the HTTP GET request to the specified endpoint (/ping).

.then() — Begins the validation/assertion phase after the response is received.

.log().all() — Logs the request and response details for debugging.

.statusCode(201) — Asserts that the HTTP response status code is 201.


 */
import io.restassured.RestAssured;

public class Lab01_APITesting_RA {

    public static void main(String[] args) {
        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com/ping")
                    .when()
                        .get()
                    .then()
                        .log().all().statusCode(201);

    }
}
