package org.Ders21_Odev.Test;

import org.Ders21_Odev.Drivers.Driver;
import org.Ders21_Odev.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Ders21Xpath1 {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();

    @BeforeSuite
    public void XpathOdev1() throws MalformedURLException {
        driver = webDriver.initializeDriver();
    }

    // Adrese gidiş
    @Test(priority = 1)
    public void sayfayaGit() {
        driver.get(propertyManager.getProperty("APP_URL"));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    // Buttons Tıkla
    @Test(priority = 2)
    public void ButtonsClick()  {
        WebElement Buttons = driver.findElement(By.xpath("//*[@id='item-4']"));
        Buttons.click();
        WebElement textButtons = driver.findElement(By.xpath("//h1[contains(text(),'Buttons')]"));
        String control = textButtons.getText();
        Assert.assertEquals(control, "Buttons");
    }

    //Click Me Düğmesine Tıkla --> Click Me düğmesi CSS selector ile seçilemedi.
    @Test(priority = 3)
    public void clickMeClick() {
        WebElement clickMe = driver.findElement(By.xpath("//button[starts-with(text(), 'Click')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickMe);
    }
    //Çıkan metni kontrol et
    @Test (priority = 4)
    public void metinOku(){
        WebElement okuMetin = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        String Metin=okuMetin.getText();
        Assert.assertEquals(Metin, "You have done a dynamic click");
    }
    @AfterSuite
    public void close() {
        webDriver.quitDriver();
    }
}