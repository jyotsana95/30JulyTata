package com.Ecommerce.Test_case;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;
import com.Ecommerce.Page_class.TC_ECommerce_Search_product;
import com.Ecommerce.Page_class.TC_Ecommerce_LoginPage;

public class Test_loginTestCase extends Ecommerce_baseclass {
@Test
	public void LoginTestcase() throws IOException, InterruptedException
	{
	logger.info("open url");
		TC_Ecommerce_LoginPage TEL = new TC_Ecommerce_LoginPage();
		TEL.RT();
		logger.info("enter Firstaname");
		TEL.FName(FName);
		logger.info("enter Lastaname");
        TEL.LName(LName);
		logger.info("enter Email");
        TEL.mail(UN);
		logger.info("enter Password");
        TEL.Pword(PW);
		logger.info("enter Confirm Password");
        TEL.CPword(CPW);
		logger.info("Click on Register");
        TEL.RegButton();
        
		String text = driver.findElement(By.xpath("//div[contains(text() ,'Your registration completed')]")).getText();
    
		if (text.equals("Your registration completed"))
		{
			Assert.assertTrue(true);
			logger.info("Registration Successful");

		}
		 
		else
		{
			getscreenshotAS("Register");
			Assert.assertTrue(false);
			logger.info("Test case fails");

		}

		TEL.CBT();
		TC_ECommerce_Search_product TSP = new TC_ECommerce_Search_product();
        TSP.search(Search);
		
		
		
	}
	
	
	
}
