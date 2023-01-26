package com.Ecommerce.Test_case;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;
import com.Ecommerce.Page_class.TC_ECommerce_Search_product;
import com.Ecommerce.Page_class.TC_Ecommerce_Login;
import com.Ecommerce.Page_class.TC_Ecommerce_LoginPage;

public class Test_loginTestCase2 extends Ecommerce_baseclass {
@Test
	public void LoginTestcase() throws IOException, InterruptedException
	{
	logger.info("open url");
	TC_Ecommerce_Login TEL1 = new TC_Ecommerce_Login();
		TEL1.LT();
		logger.info("enter Email");
        TEL1.FName(UN);
		logger.info("enter Password");
        TEL1.Pword(PW);
		logger.info("Click on Login");
        TEL1.log_in();
        
		String text = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]")).getText();
    
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

			
		
	}
	
	
	
}
