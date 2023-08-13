package com.example.shop;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;

import java.util.List;

public class ShopAPITests {

    ResponseSpecification responseShop;


    @BeforeAll
    public static void setBaseUrl() {
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
    public void shouldGetShopPositive() {
        RequestSpecification getRequest = RestAssured.given();
        Response response = getRequest.get("/shops/all");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assertions.assertEquals(bodyAsString.contains("shopName"), true);

    }

    @Test
    @DisplayName("Get shop by Id")
    public void shouldGetShopById() {
        RequestSpecification getRequest = RestAssured.given();
        Response response = getRequest.get("/shops/"+ getIdShop());

        response.then().statusCode(200);
    }

    private String getIdShop() {

        RequestSpecification getRequest = RestAssured.given();
        Response response = getRequest.get("/shops/all");

        List<String> jsonResponse = response.jsonPath().getList("$");
        jsonResponse.get(0);
        String shopId = response.jsonPath().getString("shopId[0]");
        return shopId;

    }

}
