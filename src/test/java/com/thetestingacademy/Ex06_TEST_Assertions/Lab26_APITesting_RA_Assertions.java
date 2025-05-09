package com.thetestingacademy.Ex06_TEST_Assertions;

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
import org.testng.annotations.Test;

public class Lab26_APITesting_RA_Assertions {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    @Owner("Chinna")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
    @Test
    public void test_create_booking(){
        String payload="{\n" +
                "    \"firstname\" : \"chiru\",\n" +
                "    \"lastname\" : \"white\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("chiru"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("white"));
        validatableResponse.body("booking.additionalneeds", Matchers.equalTo("Breakfast"));
        validatableResponse.body("bookingid",Matchers.notNullValue());
    }
}

//To generate the HTML Allure Report Files, run below command in terminal after running the test cases
// allure serve allure-results/

