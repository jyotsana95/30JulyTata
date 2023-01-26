package com.Ecommerce.Page_class;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;

public class TC_ECommerce_Search_product extends Ecommerce_baseclass {
	
	public TC_ECommerce_Search_product()
	{
		PageFactory.initElements(driver, this);
	}

   @FindBy(id = "small-searchterms")
   public WebElement Search;
		
   @FindBy(xpath = "//button[@type=\"submit\"]")
   public WebElement click;
		
   
   public void search(String input) 
		{
		Search.sendKeys(input);	
		}
		
   public void button() 
	{
	click.click();	
	}
		
		
		
		
		
		
		
		
	}


