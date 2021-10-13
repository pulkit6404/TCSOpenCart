package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	By searchHeader = By.xpath("//div[@id='content']/h1");
	By productList = By.xpath("//div[@class='caption']//a");
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementsUtil(driver);
	}
	
	public void isHeaderDisplayed()
	{
		elementUtil.doIsDisplayed(searchHeader);
	}
	
	public int getProductListCount()
	{
		return elementUtil.waitForElementsVisible(productList, Constants.DEAFULT_TIME_OUT).size();
	}
	
	public ProductInfo doSelectProduct(String mainProductName)
	{
		List<WebElement> productListDisplayed = elementUtil.waitForElementsVisible(productList, Constants.DEAFULT_TIME_OUT);
		for(WebElement e: productListDisplayed)
		{
			String text = e.getText();
			if(text.equals(mainProductName))
			{
				e.click();
				break;
			}
		}
		
		return new ProductInfo(driver);
		
	}

}
