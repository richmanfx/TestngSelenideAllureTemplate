package ru.performancelab.tests.pageobjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class BasePage {

    static final Logger log = LogManager.getLogger();

    @Step("Проверить отображение стартовой страницы")
    public abstract void checkPageShow();

}
