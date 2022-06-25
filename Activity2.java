package com.activities;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {

	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;

	@Test
	public void testSearchAppium() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.training-support.net/");

		String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		System.out.println("Title on Homepage: " + pageTitle);
		Thread.sleep(10000);
		MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@text='About Us']");
		aboutButton.click();

		String newPageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();

		System.out.println("Title on new page: " + newPageTitle);

		// Assertions
		Assert.assertEquals(pageTitle, "Training Support");
		Assert.assertEquals(newPageTitle, "About Us");
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "PixelEmulator");
		cap.setCapability("platformName", "android");
		cap.setCapability("automationName","UiAutomator2");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
