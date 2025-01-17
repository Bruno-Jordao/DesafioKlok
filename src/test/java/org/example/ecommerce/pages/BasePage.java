package org.example.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    protected void click(WebElement element) {

        element.click();
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void sendKeys(WebElement element, String text) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.clear();
            element.sendKeys(text);
        } else {
            System.out.println("Elemento não está disponível para interação: " + element.toString());
        }
    }

    protected String getText(WebElement element) {

        return element.getText();
    }
}
