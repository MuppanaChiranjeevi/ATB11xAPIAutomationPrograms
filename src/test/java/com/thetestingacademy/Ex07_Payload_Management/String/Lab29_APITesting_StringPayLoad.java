package com.thetestingacademy.Ex07_Payload_Management.String;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Lab29_APITesting_StringPayLoad {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @Test
    public void test_create_booking() {
        String payload = "{\n" +
                "    \"firstname\" : \"Chiranjeevi\",\n" +
                "    \"lastname\" : \"Muppana\",\n" +
                "    \"totalprice\" : 369,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2015-01-01\",\n" +
                "        \"checkout\" : \"2014-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Dinner\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();


        //TestNG Assertions
        Integer bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        Assert.assertEquals(firstname, "Chiranjeevi");
        Assert.assertEquals(lastname, "Muppana");
        Assert.assertNotNull(bookingId);

    }
}