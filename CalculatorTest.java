package com.calculator;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CalculatorTest {
	// Declare Android driver
	AndroidDriver<MobileElement> driver;

	@Test
	public void add() {
		// Using resource-id
		driver.findElementById("digit_5").click();
		// Using Accessibility ID
		driver.findElementByAccessibilityId("multiply").click();
		// Using XPath
		driver.findElementByXPath("//android.widget.Button[@text='9']").click();

		// Perform Calculation
		driver.findElementById("eq").click();

		// Display Result
		String result = driver.findElement(MobileBy.id("result")).getText();
		System.out.println(result);

		// Assertion
		Assert.assertEquals(result, "45");
	}


	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<>(appServer, caps);
	}

	@AfterClass
	public void tearDown() {
		// Close app
		driver.quit();
	}
}
