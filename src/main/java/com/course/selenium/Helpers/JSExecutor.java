package com.course.selenium.Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JSExecutor {
    WebDriver driver =  new FirefoxDriver();
    public void meth(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript(script, args);
    }
}
