package com.demo.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
public class Shopping {
    private static String PAGE_URL = "https://www.saucedemo.com/";
    WebDriver driver_ffox;
    public void setUp() throws InterruptedException {
        //Use FFox driver
        driver_ffox = new FirefoxDriver();
        driver_ffox.get(PAGE_URL);
        //full screen window
        driver_ffox.manage().window().maximize();

        String homeTitle = "nopCommerce demo store";
        String actualTitle = "";

        signIn();
        searchProduct();


        Thread.sleep(1000);
        closeBrowser();
    }

    public void signIn() throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";

        try{
            WebElement userEmail = driver_ffox.findElement(By.id("user-name"));
            userEmail.clear();
            userEmail.sendKeys(username);
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Textbox username ---> " + e.getMessage());
        }

        try{
            WebElement usersPwd = driver_ffox.findElement(By.id("password"));
            usersPwd.clear();
            usersPwd.sendKeys(password);
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Textbox password ---> " + e.getMessage());
        }

        try{
            driver_ffox.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
        } catch(NoSuchElementException e){
            System.out.println("Click Login button---> " + e.getMessage());
        }
    }
    public void searchProduct() throws InterruptedException {
        String firstName = "Carlos";
        String lastName = "Najera";
        int postalCode = 12345;

        try{
            driver_ffox.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")).click();
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Click backpack ---> " + e.getMessage());
        }
        try{
            driver_ffox.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Add to car---> " + e.getMessage());
        }
        try{
            driver_ffox.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Click to car---> " + e.getMessage());
        }
        try{
            driver_ffox.findElement(By.id("checkout")).click();
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Click to checkout---> " + e.getMessage());
        }


        try{
            WebElement userEmail = driver_ffox.findElement(By.id("first-name"));
            userEmail.clear();
            userEmail.sendKeys(firstName);
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Textbox firstName ---> " + e.getMessage());
        }
        try{
            WebElement userEmail = driver_ffox.findElement(By.id("last-name"));
            userEmail.clear();
            userEmail.sendKeys(lastName);
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Textbox lastName ---> " + e.getMessage());
        }

        try{
            WebElement userEmail = driver_ffox.findElement(By.id("postal-code"));
            userEmail.clear();
            userEmail.sendKeys(String.valueOf(postalCode));
            Thread.sleep(1000);
        } catch(NoSuchElementException e){
            System.out.println("Textbox postalCode ---> " + e.getMessage());
        }
        try{
            driver_ffox.findElement(By.id("continue")).click();
            Thread.sleep(1000);
        }catch (Exception ex){
            System.out.println("btn Cotinue ----> " + ex.getMessage());
        }
        try{
            driver_ffox.findElement(By.id("finish")).click();
            Thread.sleep(1000);
        }catch (Exception ex){
            System.out.println("btn Finish -----> "+ ex.getMessage());
        }
        backHome();
    }

    public void backHome(){
        try{
            driver_ffox.findElement(By.id("back-to-products")).click();
            Thread.sleep(1000);
        }catch (Exception ex){
            System.out.println("Back home ----->" + ex.getMessage());
        }
    }
    public void closeBrowser(){
        try {
            driver_ffox.quit();
            System.out.println("The driver has been closed.");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main( String[] args) throws InterruptedException {
       Shopping obj = new Shopping();
       obj.setUp();
    }
}

