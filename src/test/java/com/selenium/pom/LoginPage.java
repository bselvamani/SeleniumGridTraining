package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	
	@FindBy(id = "email")
	private WebElement txtEmailAddress;
	
	@FindBy(id = "passwd")
	private WebElement txtPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnSignin;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isInitialized() {
		wait.until(ExpectedConditions.visibilityOf(this.btnSignin));
		return btnSignin.isDisplayed();
	}

	public MyAccountPage onClickSignIn(String email, String pwd) {
		this.txtEmailAddress.sendKeys(email);
		this.txtPassword.sendKeys(pwd);
		this.btnSignin.click();
		return new MyAccountPage(driver);
	}
}
