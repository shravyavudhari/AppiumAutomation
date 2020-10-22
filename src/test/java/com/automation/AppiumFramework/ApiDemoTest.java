package com.automation.AppiumFramework;

import java.io.IOException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.ApiDependenciesPage;
import pageObjects.ApiPreferencesPage;

public class ApiDemoTest extends base {

	@Test
	public void apiDemoTest() throws IOException, InterruptedException {
		service=startServer();
		
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemoApp");

		ApiPreferencesPage p = new ApiPreferencesPage(driver);
		p.Preference.click();
		p.PreferenceDependencies.click();
		
		ApiDependenciesPage d = new ApiDependenciesPage(driver);
		d.checkbox.click();
		d.WifiSettings.click();
		d.Wifitextbox.sendKeys("Shravya");
		d.Okbutton.click();
		service.stop();
	}
}
