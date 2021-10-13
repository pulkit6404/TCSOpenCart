package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPwd = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	
	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@value='Continue']");
	private By successMessg = By.cssSelector("div#content h1");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	// User Registration method 
	
	public Boolean userRegistration(String firstName,  String lastName, String email, String telephone,
																			String password, String subscribe )
	{
		sendUserDetails(firstName, lastName, email, telephone, password);
		doSubscribe(subscribe);
		agreeAndContinue();
		return checkRegistrationStatus();
	}
	
	
	// private User Registration utilities
	
	private void sendUserDetails(String firstName, String lastName, String email, String telephone, String password) 
	{
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(confirmPwd, password);
	}
	
	private void doSubscribe(String subscribe)
	{
		if(subscribe.equalsIgnoreCase("Yes"))
		{
			elementUtil.doClick(subscribeYes);
		}else
		{
			elementUtil.doClick(subscribeNo);
		}
	}
	
	private void agreeAndContinue()
	{
		elementUtil.doClick(agreeCheckbox);
		elementUtil.doClick(continueButton);
	}
	
	private Boolean checkRegistrationStatus()
	{
		String RegStatusMessage = elementUtil.doGetText(successMessg);
		if(RegStatusMessage.contains(Constants.SUCCESS_REG_MESSAGE))
		{
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;
	}
	

}
