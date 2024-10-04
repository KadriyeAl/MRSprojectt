package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public static Logger logEkle= LogManager.getLogger();
    //logları ekleyeceğim kuyrugu başlattım
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri(){
       // System.out.println("Başlangıç işlemleri yapılıyor");

        driver=new ChromeDriver();
        logEkle.info("Driver Başlatıldı");

        //hata oluşmuş olsaydı
        logEkle.error("Driver oluşturulurken hata oluştu");

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Login();
    }

    @AfterClass
    public void KapanisIslemleri(){
        //System.out.println("Kapanis işlemleri yapılıyor");

        Tools.Bekle(3);
        driver.quit();
    }

    public void Login() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("kadriyealsancak@gmail.com");
        logEkle.info("şu anda"+"kadriyealsancak@gmail.com"+"isimli user login olmak için gönderildi");


        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("4521354Ka");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        logEkle.debug("Login işlemine geçiliyor");

        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");
        logEkle.info("login işlemi başarıyla yapıldı");
        logEkle.warn("login işlemlerinde kadriyealsancak@gmail.com kullanıcıda önemli hata oluştu");
    }
    @BeforeMethod
    public void BeforeMethod()
    {
        logEkle.info("Metod çalışmaya başladı");


    }
    @AfterMethod
    public void AfterMethod(ITestResult sonuc)
    {
       logEkle.info(sonuc.getName()+"Metıd çalışması tamamlandı");
       logEkle.info(sonuc.getStatus()==1 ?"Passed" : "failed");

       //çok önemli hata oldu/fatal eror
        logEkle.fatal(sonuc.getName()+"Metod da çok önemli bir hata oldu");
    }

}
