package ru.performancelab.tests.suites.Smoke;


import org.testng.annotations.Test;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import ru.performancelab.tests.BaseTest;
import ru.performancelab.tests.pageobjects.BasePage;
import ru.performancelab.tests.pageobjects.StartPage;

import java.util.Date;

import static com.codeborne.selenide.Selenide.open;


@Test(groups = {"Smoke"})
public class Smoke extends BaseTest {

    @BeforeClass
    public void hostAccessibility() {

        // Получить URL: по умолчанию - для Idea, а для gradle - из "gradle.properties"
        String testUrl = System.getProperty("testUrl", "https://r5am.ru");

        hostAccessibility(testUrl);
    }

    @Description("Описание метода 'checkStartPageDisplaying'")
    @Test(description="Проверка отображения стартовой страницы")
    public void checkStartPageDisplaying() {
        log.debug(String.format("Start method: %s", Thread.currentThread().getStackTrace()[1].getMethodName()));
        StartPage startPage = new StartPage();
        startPage.checkPageShow();

    }


    /**
     * Проверить доступность хоста
     * @param testUrl URL хоста
     */
    private void hostAccessibility(String testUrl) {

        checkPageAccessibility(testUrl, new StartPage());
        log.info("Хост доступен");
//        screenShot("Отображение стартовой страницы хоста");       // TODO: Скриншот в Аллюре
    }


    /**
     * Проверить доступность страницы
     * @param url URL страницы
     * @param page Объект PageObject страницы
     */
    private void checkPageAccessibility(String url, BasePage page) {
        log.info(String.format("URL тестирумого автотестами хоста: '%s'", url));

        // Открыть страницу
        long beginOpenSiteTime = new Date().getTime();    // Время начала открывания страницы
        open(url);

        // Проверить отображение страницы
        page.checkPageShow();
        long endOpenSiteTime = new Date().getTime();    // Время окончания открытия страницы

        log.info(String.format("Время открывания страницы '%s': %d секунд.",
                url, (endOpenSiteTime - beginOpenSiteTime) / 1000)
        );
    }

}
