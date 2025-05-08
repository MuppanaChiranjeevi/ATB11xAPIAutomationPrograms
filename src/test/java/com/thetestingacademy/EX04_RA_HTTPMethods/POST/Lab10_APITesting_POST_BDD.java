package com.thetestingacademy.EX04_RA_HTTPMethods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab10_APITesting_POST_BDD {

    @Test
    public void test_POST_AUTH(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/auth")
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .log().all()
                    .when()
                        .log().all()
                        .post()
                    .then()
                        .log().all()
                        .statusCode(200);


    }
    @Test
    public void test_POST_AUTH_NoLogALL(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post()
                .then()
                .statusCode(200);


    }

}
