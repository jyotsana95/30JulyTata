package com.Ecommerce.Page_class;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;

public class TC_Ecommerce_Login extends Ecommerce_baseclass  {
	public TC_Ecommerce_Login()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class=\"ico-login\"]")
	public WebElement LoginTab;

	@FindBy(id = "Email")
	public WebElement UN;

	@FindBy(id = "Password")
	public WebElement PW;
	
	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")
	public WebElement login;

	@FindBy(xpath = "//a[@class=\"ico-logout\"]")
	public WebElement logout;
	
	public void LT()
	{
		LoginTab.click();
	}		

	public void FName(String username) 
	{
	UN.sendKeys(username);	
	}
	
	public void Pword(String password) 
	{
	PW.sendKeys(password);	
	}
	
	public void log_in() 
	{
	login.click();	
	}
	
	public void LO() 
	{
	logout.click();	
	}
	
	
	
	
	
	
	
	
	
	
}
