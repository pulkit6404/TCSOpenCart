package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageUrlTest()
	{
		String url =loginPage.loginPageUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_TEXT));
	}
	
	@Test
	public void isRegisterLinkDisplayedTest()
	{
		Assert.assertTrue(loginPage.isRegisterLinkDisplayed());
	}
	
	@Test
	public void isForgotPsasswordLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPsasswordLinkExist());
	}
	
	@Test
	public void loginTest()
	{
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
}
