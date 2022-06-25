package com.activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	AndroidDriver<MobileElement> driver;
  @Test
  public void add() {
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementByAccessibilityId("plus").click();
	  driver.findElementById("com.android.calculator2:id/digit_9").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  String result = driver.findElementById("com.android.calculator2:id/result").getText();
	  Assert.assertEquals(result, "14");	  
  }
  
  @Test
  public void subtract() {
	  driver.findElementById("com.android.calculator2:id/digit_1").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementByAccessibilityId("minus").click();
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  String result = driver.findElementById("com.android.calculator2:id/result").getText();
	  Assert.assertEquals(result, "5");	  
  }
  
  @Test
  public void multiply() {
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementByAccessibilityId("multiply").click();
	  driver.findElementById("com.android.calculator2:id/digit_1").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  String result = driver.findElementById("com.android.calculator2:id/result").getText();
	  Assert.assertEquals(result, "500");	  
  }
  
  @Test
  public void divide() {
	  driver.findElementById("com.android.calculator2:id/digit_5").click();
	  driver.findElementById("com.android.calculator2:id/digit_0").click();
	  driver.findElementByAccessibilityId("divide").click();
	  driver.findElementById("com.android.calculator2:id/digit_2").click();
	  driver.findElementById("com.android.calculator2:id/eq").click();
	  String result = driver.findElementById("com.android.calculator2:id/result").getText();
	  Assert.assertEquals(result, "25");	  
  }
  
  
  @BeforeClass
  public void setUp() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "PixelEmulator");
	  caps.setCapability("platformName", "android");
	  caps.setCapability("automationName", "UiAutomator2");
	  caps.setCapability("appPackage", "com.android.calculator2");
	  caps.setCapability("appActivity", ".Calculator");
	  caps.setCapability("noReset", true);
	  
	  URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
	  driver = new AndroidDriver<>(appServer,caps);
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
