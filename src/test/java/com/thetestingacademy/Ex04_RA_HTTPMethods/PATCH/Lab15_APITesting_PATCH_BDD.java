package com.thetestingacademy.Ex04_RA_HTTPMethods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab15_APITesting_PATCH_BDD {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd() {

        String token = "73969a9004e7d32";
        String bookingid = "22316";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"chiranjeevi\",\n" +
                "    \"lastname\" : \"muppana\"\n" +
                "}";


        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/booking/" + bookingid)
                        .contentType(ContentType.JSON)
                        .cookie("token", token)
                        .body(payloadPUT).log().all()
                  .when()
                        .log().all().patch()
                  .then()
                        .log().all()
                        .statusCode(200);
    }
}
