package com.automation.AppiumFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;
import pageObjects.ProductsPage;

public class EcommerceTC1 extends base {
	@Test
	public void sumValidation() throws IOException, InterruptedException {
		service=startServer();
		AndroidDriver <AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formPage = new FormPage(driver);
		formPage.nameField.sendKeys("shravya");
		driver.hideKeyboard();
		formPage.radioFemale.click();
		formPage.selectCountry.click();
		ScrollUtility scroll = new ScrollUtility(driver);
		scroll.scrollToText("Belgium");
		scroll.clickOnText("Belgium");
		formPage.LetsShopButton.click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("shravya");
//		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//		driver.findElement(By.id("android:id/text1")).click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))");
//		driver.findElement(By.xpath("//*[@text='Belgium']")).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		ProductsPage products =  new ProductsPage(driver);
		products.addButton.get(0).click();
		products.addButton.get(0).click();
		products.GoToCartButton.click();
//		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
//		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		CheckoutPage checkOutPage =  new CheckoutPage(driver);
		
		String amount1 = checkOutPage.Productprices.get(0).getText();
		Double amount1value = getAmount(amount1);
		
		String amount2 = checkOutPage.Productprices.get(1).getText();
		Double amount2value = getAmount(amount2);
		
		Double TotalSum = amount1value+amount2value;
		System.out.println(TotalSum+"sum of products");
		
		String BillAmount = checkOutPage.BillAmount.getText();
		Double Billvalue = getAmount(BillAmount);

		System.out.println(TotalSum+"Bill amount products");

		Assert.assertEquals(TotalSum,Billvalue);
//		Assert.assertEquals(TotalSum,"280");
		service.stop();
	}
	
	
	public double getAmount(String value) {
		value = value.substring(1);
		Double Numbervalue = Double.parseDouble(value);
		return Numbervalue;
	}
	@BeforeSuite
	public void killAllNodes() throws IOException {
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
	}
}
