package com.automation.AppiumFramework;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollUtility {
	AndroidDriver<AndroidElement> driver;
	
	public ScrollUtility(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");	
	}
	
	public void clickOnText(String text) {
		driver.findElement(By.xpath("//*[@text='"+text+"']")).click();
	}
	
}

