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
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
public class Lab28_APITesting_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    Integer bookingId;
    @Owner("Chinna")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
    @Test
    public void test_create_booking(){
        String payload="{\n" +
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
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();

        //REST Assured Assertions
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Chiranjeevi"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Muppana"));
        validatableResponse.body("booking.additionalneeds", Matchers.equalTo("Dinner"));
        validatableResponse.body("bookingid",Matchers.notNullValue());

        //TestNG Assertions
        // HardAssert
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        Assert.assertEquals(firstname,"Chiranjeevi");
        Assert.assertEquals(lastname,"Muppana");
        Assert.assertNotNull(bookingId);

        // AssertJ( 3rd- Lib to Assertions)
        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Chiranjeevi").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();

        //        String s1 = ""; //Empty
        //        String s2 = " "; //Blank
    }
}
