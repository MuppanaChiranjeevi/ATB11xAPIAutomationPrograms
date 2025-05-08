package com.thetestingacademy.EX04_RA_HTTPMethods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab14_APITesting_DELETE_NONBDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd() {

        String token = "b7660ea3fa03705";
        String bookingid = "1105";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.log().all();

        System.out.println("--------------------------------------------");

        response = r.when().log().all().delete();

        System.out.println("--------------------------------------------");
        vr = response.then().log().all();
        vr.statusCode(201);


    }
}
