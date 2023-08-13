package com.example.shop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class ShopUITest {

    ShopPage shopPage;

    @BeforeAll
    public static void setProperty() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        Configuration.baseUrl = "http://localhost:4000";
    }

    @AfterEach
    public void closeAfterEach() {

        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Check the work")
    public void shouldCheckWork() throws InterruptedException {
        shopPage = new ShopPage();

        open("/");
        step("Title check", () -> {
            shopPage.titleShop.shouldBe(Condition.visible);
        });

    }

    @Test
    @DisplayName("Create new shop")
    public void shouldAddShop() throws InterruptedException {

        shopPage = new ShopPage();
        String newShopName = "Sv" + LocalDateTime.now().toString();

        open("/");
        step("Page load check", () -> {
            shopPage.tableShop.shouldBe(Condition.visible);
        });

        step("Check created shop on UI", () -> {
            shopPage.placeholderCreate.shouldBe(Condition.visible);
            shopPage.placeholderCreate.sendKeys(newShopName);
            shopPage.buttonCreate.click();
        });

        switchTo().alert().dismiss();

        step("Find new shop", () -> {
            shopPage.divShops.shouldHave(text(newShopName));
        });
    }
}
