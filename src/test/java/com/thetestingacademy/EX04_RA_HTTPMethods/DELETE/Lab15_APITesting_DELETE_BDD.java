package com.thetestingacademy.EX04_RA_HTTPMethods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab15_APITesting_DELETE_BDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd() {

        String token = "8398e0318c4ec33";
        String bookingid = "14201";
        
        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/booking/" + bookingid)
                        .contentType(ContentType.JSON)
                        .cookie("token", token)
                        .log().all()
                    .when()
                        .log().all().delete()
                    .then()
                        .log().all()
                        .statusCode(201);


    }
}
