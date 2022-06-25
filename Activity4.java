package com.activities;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	AndroidDriver driver;
	WebDriverWait wait;
	@Test
	public void contacts() {
		driver.findElementByAccessibilityId("Create new contact").click();  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aditya");
		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Sharma");
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("99912345");
		driver.findElementByXPath("//android.widget.Button[@text='SAVE']").click();

		Assert.assertTrue(driver.findElementById("com.android.contacts:id/title_gradient").isDisplayed());

	}
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName","UiAutomator2");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", ".activities.PeopleActivity");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<>(appServer,caps);
		wait = new WebDriverWait(driver, 5);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
