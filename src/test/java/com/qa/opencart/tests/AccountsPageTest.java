package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{
	
	
	@BeforeClass
	public void accountPageSetup()
	{
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password"));
	}
	
	@Test
	public void accountsPageTitleTest()
	{
		String title = accountPage.accountsPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void accountsPageUrlTest()
	{
		String url = accountPage.accountsPageUrl();
		Assert.assertTrue(url.contains(Constants.ACCOUNTS_PAGE_URL_TEXT));
	}
	
	@Test
	public void isSearchFieldExistTest()
	{
		Assert.assertTrue(accountPage.isSearchFieldExist());
	}
	
	@Test(enabled = false)
	public void isAddressBookLinkExistTest()
	{
		Assert.assertTrue(accountPage.isAddressBookLinkExist());
	}
	
	@Test
	public void accountsPageHeadersTest()
	{
		List<String> headers = accountPage.accountsPageHeaders();
		System.out.println(headers);
		Assert.assertEquals(headers, Constants.ACCOUNT_PAGE_HEADERS);
	}
	
	@DataProvider
	public Object[][] productSearchData()
	{
		return new Object[][]{
				{"macbook"},
				{"imac"},
				{"Apple"}
		};
	}
	
	@Test(dataProvider = "productSearchData")
	public void doSearchTest(String productName)
	{
		resultPage = accountPage.doSearch(productName);
		Assert.assertTrue(resultPage.getProductListCount()>0);
	}
	
	@DataProvider
	public Object[][] mainProductData()
	{
		return new Object[][]{
				{"macbook","MacBook Pro"},
				{"imac","iMac"},
				{"Apple","Apple Cinema 30\""}
		};
	}
	@Test(dataProvider = "mainProductData")
	public void selectmainProductTest(String productname, String mainProductName)
	{
		resultPage = accountPage.doSearch(productname);
		resultPage.doSelectProduct(mainProductName);
	}
	
	

}
