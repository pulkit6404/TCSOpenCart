package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementsUtil;

public class ProductInfo {
	
	private WebDriver driver;
	private ElementsUtil elementUtil;
	
	By productHeader = By.cssSelector("div#content h1");
	By productImages = By.cssSelector("ul.thumbnails img");
	By productQuantity = By.id("input-quantity");
	By addToCartButton = By.id("button-cart");
	
	public ProductInfo(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getProductHeader()
	{
		return elementUtil.doGetText(productHeader);
	}
	
	public int getProductImageCount()
	{
		return elementUtil.waitForElementsPresence(productImages, Constants.DEAFULT_TIME_OUT).size();
	}
	


}
