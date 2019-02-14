package ru.performancelab.tests.pageobjects;


import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;


public class StartPage extends BasePage {


    /**
     * Проверить отображение стартовой страницы
     */
    @Override
    public void checkPageShow() {

        try {
            SelenideElement headerElement = $(By.xpath("//h1"));
            headerElement.shouldHave(text("R5AM"));
            log.info("Стартовая страница удачно отобразилась");
        } catch (NoSuchElementException ex) {
            log.error(String.format("Стартовая страница не открылась: '%s'", ex.getMessage()));
            assert false;
        }
    }

}
