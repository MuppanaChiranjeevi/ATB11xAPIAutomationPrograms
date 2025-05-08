package com.thetestingacademy.EX04_RA_HTTPMethods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab13_APITesting_PUT_BDD {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd() {

        String token = "fecf23fe69b9023";
        String bookingid = "1175";

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


        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" + bookingid)
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(payloadPUT)
                .when().log().all().put()
                .then().log().all()
                .statusCode(200);

    }
}
