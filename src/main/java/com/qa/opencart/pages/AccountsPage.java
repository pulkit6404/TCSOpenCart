package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	By search = By.name("search");
	By addressBookLink = By.linkText("Address Book");
	By accountPageHeaders = By.xpath("//div[@id='content']/h2");
	By logoutLink = By.linkText("Logout");
	By searchButton = By.xpath("//span[@class='input-group-btn']/button[@type='button']");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	public String accountsPageTitle()
	{
		return elementUtil.waitForTitleToBe(Constants.DEAFULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public String accountsPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean isSearchFieldExist()
	{
		return elementUtil.doIsDisplayed(search);
	}
	
	public boolean isLogoutLinkExist()
	{
		return elementUtil.doIsDisplayed(logoutLink);
	}
	
	public boolean isAddressBookLinkExist()
	{
		return elementUtil.doIsDisplayed(addressBookLink);
	}
	
	public List<String> accountsPageHeaders()
	{
		List<WebElement> headers = elementUtil.getElements(accountPageHeaders);
		List<String> headersList = new ArrayList<String>();
		for(WebElement e: headers)
		{
			String text = e.getText();
			headersList.add(text);
		}
		
		return headersList;
	}
	
	public ResultsPage doSearch(String productName)
	{
		System.out.println("Product name is :" + productName);
		elementUtil.doSendKeys(search, productName);
		elementUtil.doClick(searchButton);
		return new ResultsPage(driver); 
	}

}
