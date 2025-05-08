package com.thetestingacademy.Ex04_RA_HTTPMethods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab09_APITesting_GET_NONBDD {
    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;
    String pincode;
    @Test
    public void test_GET_NONBDD_POSITIVE_TC1(){
        pincode = "560066";
        //GIVEN
        rs=RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/"+pincode);
        System.out.println("---------------------------");
        //WHEN
        r=rs.when().log().all().get();
        System.out.println(r.asString());
        System.out.println("---------------------------");
        //THEN
        vr=r.then().log().all();
        vr.statusCode(200);
    }
    @Test
    public void test_GET_NONBDD_NEGATIVE_TC2(){
        pincode = "!@#$%";
        //GIVEN
        rs=RestAssured.given();
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/"+pincode);
        System.out.println("---------------------------");
        //WHEN
        r=rs.when().log().all().get();
        System.out.println(r.asString());
        System.out.println("---------------------------");
        //THEN
        vr=r.then().log().all();
        vr.statusCode(404);
    }
}
