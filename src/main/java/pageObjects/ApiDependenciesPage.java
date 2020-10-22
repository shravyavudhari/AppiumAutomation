package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDependenciesPage {
	
	public ApiDependenciesPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@index=2]")
	public WebElement WifiSettings;
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement Wifitextbox;

	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public WebElement Okbutton;
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement checkbox;
}
