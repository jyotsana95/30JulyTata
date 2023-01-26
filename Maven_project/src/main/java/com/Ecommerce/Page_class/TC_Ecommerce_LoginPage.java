package com.Ecommerce.Page_class;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecommerce.Baseclass.Ecommerce_baseclass;

public class TC_Ecommerce_LoginPage extends Ecommerce_baseclass {

public TC_Ecommerce_LoginPage()
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[@class=\"ico-register\"]")
public WebElement Tab;

@FindBy(id = "FirstName")
public WebElement FN;

@FindBy(id = "LastName")
public WebElement LN;
		

@FindBy(id = "Email")
public WebElement email;

@FindBy(id = "Password")
public WebElement PW;

@FindBy(id = "ConfirmPassword")
public WebElement CPW;

@FindBy(id = "register-button")
public WebElement register;
				


@FindBy(xpath = "//a[@class=\"button-1 register-continue-button\"]")
public WebElement Cbutton;
				
public void RT()
{
	Tab.click();
}		

public void FName(String username) 
{
FN.sendKeys(username);	
}

public void LName(String username) 
{
LN.sendKeys(username);	
}

public void mail(String username) 
{
email.sendKeys(username);	
}

public void Pword(String password) 
{
PW.sendKeys(password);	
}
public void CPword(String username) 
{
CPW.sendKeys(username);	
}

public void RegButton()
{
	register.click();
}



public void CBT()
{
	Cbutton.click();
}

}
