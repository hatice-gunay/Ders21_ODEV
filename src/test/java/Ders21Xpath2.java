package org.Ders21_Odev.Test;


import org.Ders21_Odev.Drivers.Driver;
import org.Ders21_Odev.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class Ders21Xpath2 {
    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager = new PropertyManager();
String url =propertyManager.getProperty("APP_URL2");

    @BeforeSuite
    public void XpathOdev2() throws MalformedURLException {
        driver = webDriver.initializeDriver();
    }

    // Adrese gidiş
    @Test(priority = 1)
    public void sayfayaGit() {
        driver.get(url);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "DEMOQA");
    }

    //Add butonuna tıklama
    @Test(priority = 2)
    public void Add() {
        WebElement Add = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        Add.click();
        WebElement textWebtables = driver.findElement(By.xpath("//div[@id='registration-form-modal']"));
        String control = textWebtables.getText();
        Assert.assertEquals(control, "Registration Form");
    }

    //First name girişi
    @Test(priority = 3)
    public void firstName() {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.click();
        firstName.sendKeys("Hatice");
    }

    //Last name giriş
    @Test(priority = 4)
    public void lastName() {
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.click();
        lastName.sendKeys("Günay");
    }

    //e-mail giriş
    @Test(priority = 5)
    public void eMail() {
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.click();
        eMail.sendKeys("hatice.turegun@gmail.com");
    }

    //Age giriş
    @Test(priority = 6)
    public void age() {
        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.click();
        age.sendKeys("44");
    }

    //Salary giriş
    @Test(priority = 7)
    public void salary() {
        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.click();
        salary.sendKeys("0");
    }

    // Departman giriş
    @Test(priority = 8)
    public void department() {
        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.click();
        department.sendKeys("Kalite");
    }

    //Submit
    @Test(priority = 9)
    public void submit() {
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
    }
    
    // edit düğmesine basma ve form sayfasına gitme
    @Test(priority = 10)
    public void edit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement duzenle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='edit-record-4']")));
        duzenle.click();
    }

    // Yaş bilgisini editleme ve submit etme
    @Test(priority = 11)
    public void newAge() {
        WebElement ageEdit = driver.findElement(By.xpath("//input[@id='age']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ageEdit);
        ageEdit.click();
        ageEdit.clear();
        ageEdit.sendKeys("45");

    }
    @Test(priority = 12)
    public void submitClick(){
        WebElement editSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", editSubmit);
    }
    @Test(priority = 13)
    public void agecontrol() {
        WebElement newage = driver.findElement(By.xpath("//div[contains(text(),'45')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", newage);

    }
    @AfterSuite
    public void close() {
        webDriver.quitDriver();
    }
}