package com.example.shop;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.Matchers.equalTo;

public class ShopAPITests {

   // RequestSpecification request;
    ResponseSpecification responseShop;

    @BeforeAll
    public static void setBaseUrl (){
        RestAssured.baseURI = "http://localhost:4000";
    }

    @BeforeEach
    public void setUp() {
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200);
        responseShop = specBuilder.build();
    }

    @Test
    @DisplayName("Get all shops")
    public void shouldGetByCityPositive() {
        RequestSpecification getRequest = RestAssured.given();
        Response getResponse = getRequest.get("/shops/all");
        getResponse.then().statusCode(200);
    }
//
//    @Test
//    @DisplayName("Create new shop")
//    public void shouldAddShop() {
//        RequestSpecification getRequest = RestAssured.given();
//        Response getResponse = getRequest.get("/shops/all");
//        getResponse.then().statusCode(200);
//    }



}
