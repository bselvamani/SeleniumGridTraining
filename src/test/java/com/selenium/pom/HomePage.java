package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	@FindBy(linkText = "Contact us")
	private WebElement lnkContactUs;
	
	@FindBy(className = "login")
	private WebElement lnkSignIn;

	public HomePage(WebDriver driver) {
		super(driver);
		openURL();
	}
	
	public boolean isInitialized() {
		return lnkSignIn.isDisplayed();
	}
	
	public LoginPage onClicklogin() {
		this.lnkSignIn.click();
		return new LoginPage(driver);
	}

}
