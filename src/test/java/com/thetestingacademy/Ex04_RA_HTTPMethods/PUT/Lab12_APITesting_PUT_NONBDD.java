package com.thetestingacademy.Ex04_RA_HTTPMethods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab12_APITesting_PUT_NONBDD {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd() {

        String token = "6eebb8c1ba825ee";
        String bookingid = "1210";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Roman\",\n" +
                "    \"lastname\" : \"Reigns\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
//        r.auth().oaut
        r.cookie("token", token);
        r.body(payloadPUT).log().all();

        System.out.println("--------------------------------------------");

        response = r.when().log().all().put();

        System.out.println("--------------------------------------------");
        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
