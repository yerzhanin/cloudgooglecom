package MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AllProducts {
    private static final String MAIN_URL = "https://cloud.google.com";
    private static final String ALL_PRODUCTS_BTN = "//a[@class='cloud-button cloud-button--flat']";
    private static final String SEE_PRICING_BTN = "//a[contains(text(),'See Pricing')]";
    private static final String CALCULATORS = "//a[contains(text(),'Calculators')]";
    private static final String COMPUTE_ENGINE_BTN = "//*[@id=\"mainForm\"]";

    private static final Logger log = Logger.getLogger(String.valueOf(AllProducts.class));  

    private WebDriver driver = new ChromeDriver();


    @BeforeMethod
    private void GoToCalculators(){
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        driver.findElement(By.xpath(ALL_PRODUCTS_BTN)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEE_PRICING_BTN)));
        driver.findElement(By.xpath(SEE_PRICING_BTN)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CALCULATORS)));
        driver.findElement(By.xpath(CALCULATORS)).click();
        log.info("Информ сообщение");
    }

    @Test
    private void CalculatorPage(){
                String Expected = driver.findElement(By.xpath(COMPUTE_ENGINE_BTN)).getText();
        Assert.assertEquals(Expected, "Instances\n");

    }

    @AfterMethod
    private void CloseWebDriver(){
        driver.quit();
    }



}
