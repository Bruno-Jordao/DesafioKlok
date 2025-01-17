package org.example.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private final By searchBox = By.id("input-search");
    private final By productGrid = By.cssSelector("[data-testid='product-title']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void searchProduct(String productName) {
        WebElement searchField = waitForElementToBeVisible(searchBox);
        sendKeys(searchField, productName);
        searchField.submit();
    }

    public boolean isProductListDisplayed() {
        try {
            List<WebElement> produtosReais = driver.findElements(By.cssSelector(".produto-resultado[data-result='true']"));
            return !produtosReais.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateFirstProductContains(String keyword) {
        List<WebElement> products = driver.findElements(productGrid);
        return products.get(0).getText().toLowerCase().contains(keyword.toLowerCase());
    }
}
