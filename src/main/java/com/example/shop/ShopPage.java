package com.example.shop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ShopPage {
    public SelenideElement titleShop = $("#greetings");
    public SelenideElement tableShop = $("#shops_div");
    public SelenideElement formCreateShop = $("#create");
    public SelenideElement placeholderCreate = formCreateShop.$("#name");
    public SelenideElement buttonCreate = formCreateShop.$(byText("Create shop"));
    public SelenideElement divShops = $("#shops_div");

}
