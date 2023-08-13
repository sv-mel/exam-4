package com.example.shop;

import com.example.shop.controllers.ShopController;
import com.example.shop.models.ShopDto;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShopUnitTests {


    static RequestSpecification request;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:4000";
        request = RestAssured.given();
    }

    @Test
    @DisplayName("Add shop with correct name")
    public void shouldAddShopPositive() {
        final ShopDto shop = new ShopDto(444444L,"Ttttttttttt", true);
        ShopController shopController = new ShopController();
        String res = shopController.addShop(shop).toString();
        assertThat(res, containsString("200"));
    }

    @Test
    @DisplayName("Add shop with short name")
    public void shouldAddShopNegativeShort() {
        final ShopDto shop = new ShopDto(444444L,"rrrr", true);
        ShopController shopController = new ShopController();
        String res = shopController.addShop(shop).toString();
        assertThat(res, containsString("Name should be more than 6 letters"));
    }

    @Test
    @DisplayName("Add shop with incorrect name")
    public void shouldAddShopNegative() {
        final ShopDto shop = new ShopDto(444444L,"55555555555", true);
        ShopController shopController = new ShopController();
        String res = shopController.addShop(shop).toString();
        assertThat(res, containsString("Name should begin with a capital letter"));
    }

}
