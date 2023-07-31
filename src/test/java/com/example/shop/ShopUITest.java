package com.example.shop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ShopUITest {
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
    public void shouldCheckWork() throws InterruptedException {


        open("/");
        step("Title check", () -> {
            $("#greetings").shouldBe(Condition.visible);
        });
    }
}
