package PACKAGE_NAME;

import Utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class US_406_ extends BaseDriver {

    @Test
    @Parameters("mesaj")
    public  void US406Test(String Id)  {
        // Sayfaya git
        driver.get("https://openmrs.org/tr/");
        Actions actions = new Actions(driver);
        US_406_Elements elements= new US_406_Elements();

        // Demo butonuna tıkla
        elements.demoBtn.click();

        // OpenMRS2 butonu görünene kadar bekle ve tıkla
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'elementor-widget')]//a/span)[4]")));
        elements.openMRS2.click();

        // Username kutusuna "Admin"  gir
        elements.usename.sendKeys("Admin");
        // Password kutusuna "Admin123" gir
        elements.password.sendKeys("Admin123");

        // Location for this session: elementini bul
        List<WebElement> sessionLocation = driver.findElements(By.xpath("//ul[@id='sessionLocation']/li"));

        // Seçmek için elementin locator sayısı sınırı olmak şartıyla random sayı üret
        int randomNum = MyFunc.randomGenerator(sessionLocation.size());

        // Seçilen random sayısı ile elemente tıklat
        String sessionLocationName = sessionLocation.get(randomNum).getText();
        sessionLocation.get(randomNum).click();

        // Login butonuna tıklat
        WebElement logInBuuton = driver.findElement(By.id("loginButton"));
        logInBuuton.click();

        // Find Patient Record butonu görünene kadar bekle ve tıklat
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")));
        elements.findPatientRecord.click();

        // Search kısmı açılana kadar bekle ve oradaki bir hastanın ID sini gir
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='patient-search']")));
        elements.search.sendKeys(Id);

        // Hasta seçilebilir olana kadar bekle ve tıklat
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='odd']")));
        elements.identifier.click();

        Assert.assertTrue(elements.IdAlani.getText().contains(Id));
    }

}
