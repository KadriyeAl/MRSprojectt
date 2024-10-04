package Utility;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver {

    //public static Logger logEkle= LogManager.getLogger();
    //logları ekleyeceğim kuyrugu başlattım
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri(){
       // System.out.println("Başlangıç işlemleri yapılıyor");

        driver=new ChromeDriver();
       // logEkle.info("Driver Başlatıldı");

        //hata oluşmuş olsaydı
        //logEkle.error("Driver oluşturulurken hata oluştu");

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }

    @AfterClass
    public void KapanisIslemleri(){
        //System.out.println("Kapanis işlemleri yapılıyor");

        Tools.Bekle(3);
        driver.quit();
    }


    }


