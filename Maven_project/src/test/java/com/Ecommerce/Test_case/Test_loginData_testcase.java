package com.Ecommerce.Test_case;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;
import com.Ecommerce.Page_class.TC_Ecommerce_Login;
import com.Ecommerce.Utility_data.XLSUtils;

public class Test_loginData_testcase extends Ecommerce_baseclass{
	
	@Test(dataProvider = "LoginData")
	
	public void loginData(String username, String password, String status) throws IOException
	{
		logger.info("open url");
		TC_Ecommerce_Login TEL1 = new TC_Ecommerce_Login();
			TEL1.LT();
			logger.info("enter Email");
	        TEL1.FName(username);
			logger.info("enter Password");
	        TEL1.Pword(password);
			logger.info("Click on Login");
	        TEL1.log_in();
	        
	        String Actual_result = driver.getTitle();
	        String Expected_result = "nopCommerce demo store";
	        
	        
			if (status.equals("valid"))
			{
				if(Actual_result.equals(Expected_result))
				{TEL1.LO();
				Assert.assertTrue(true);
				logger.info("login Successful");
				}
				
				else {
					Assert.assertTrue(false);
					}
			}
			 
			else if (status.equals("invalid"))
			{
				
				if(Actual_result.equals(Expected_result))
				{TEL1.LO();
				Assert.assertTrue(false);
 				}
				
				else {
					Assert.assertTrue(true);
					}

			}


		
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path ="C:\\Users\\Rahul\\Desktop\\30 july.xlsx";
		int row_num =XLSUtils.GetRowCount(path, "Sheet 4");
		int cell_num = XLSUtils.GetCellCount(path,"Sheet 4" , 1);
		String LoginData[][]= new String [row_num][cell_num];
		for (int i=1; i<=row_num;i++)
		{
			for(int j=0; j<cell_num; j++)
			{
			LoginData[i-1][j] =	XLSUtils.GetCellData(path, "Sheet 4", i, j);
			}
			
		}
		
		return LoginData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
