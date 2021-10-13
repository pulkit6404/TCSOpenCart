package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void regPageSteup()
	{
		regPage = loginPage.performUserRegisteration();
	}
	
	@DataProvider
	public Object[][] getRegPageData()
	{
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider = "getRegPageData")
	public void userRegistrationTest(String firstName, String lastName, String email, 
											String telephone, String password, String subscribe)
	{
		regPage.userRegistration(firstName, lastName, email, telephone, password,  subscribe);
	}

}
