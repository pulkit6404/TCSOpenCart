package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	// By locators
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");
	By forgotPassword = By.linkText("Forgotten Password");
	By registerLink = By.linkText("Register");
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	// actions methods
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String loginPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean isRegisterLinkDisplayed()
	{
		return elementUtil.doIsDisplayed(registerLink);
	}
	
	public boolean isForgotPsasswordLinkExist()
	{
		return elementUtil.doIsDisplayed(forgotPassword);
	}
	
	public AccountsPage doLogin(String user, String pwd) {
		elementUtil.doSendKeys(username, user);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public RegistrationPage performUserRegisteration()
	{
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}

}
