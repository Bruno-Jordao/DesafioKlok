package org.example.ecommerce.tests;

import org.example.ecommerce.drivers.DriverFactory;
import org.example.ecommerce.pages.HomePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EcommerceSearchTest {

    private HomePage homePage;

    @BeforeAll
    public void setup() {
        homePage = new HomePage(DriverFactory.getDriver());
    }

    @AfterAll
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test
    @DisplayName("Caso de sucesso: busca por produto existente")
    public void testSearchSuccess() {
        homePage.open("https://www.magazineluiza.com.br");
        homePage.searchProduct("Notebook");
        assertTrue(homePage.isProductListDisplayed(), "Produtos não foram exibidos!");
        assertTrue(homePage.validateFirstProductContains("notebook"), "Primeiro produto não corresponde!");
    }

    @Test
    @DisplayName("Fluxo alternativo: busca sem resultados")
    public void testSearchNoResults() {
        homePage.open("https://www.magazineluiza.com.br");
        homePage.searchProduct("ProdutoInexistente12345");
        assertFalse(homePage.isProductListDisplayed(), "Resultados encontrados para um produto inexistente!");
    }
}
