package PACKAGE_NAME;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_406_Elements {
    public US_406_Elements() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demoBtn;

    @FindBy(xpath = "(//div[contains(@class,'elementor-widget')]//a/span)[4]")
    public WebElement openMRS2;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usename;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='password']")
    public List<WebElement> sessionLocation;

    @FindBy(xpath = "//input[@id='loginButton']")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    public WebElement findPatientRecord;

    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement search;

    @FindBy(xpath = "//tr[@class='odd']")
    public WebElement identifier;

    @FindBy(xpath = "//div[@class='float-sm-right']/span")
    public WebElement IdAlani;







}
