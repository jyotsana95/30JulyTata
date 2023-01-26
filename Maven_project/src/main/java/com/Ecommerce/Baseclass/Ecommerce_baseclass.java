package com.Ecommerce.Baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Ecommerce.Utility_data.TestUtils;
import com.Ecommerce_configuration.ReadConfig;

public class Ecommerce_baseclass {

	ReadConfig RC= new ReadConfig();
	public String BaseUrl= RC.getapplicationUrl();
	public String FName= RC.getFirstname();
	public String LName= RC.getLastName();
	public String UN= RC.getEmail();
    public String PW= RC.getPassword();
	public String CPW= RC.getConfirmPassword();
	public String Search= RC.getSearch();


	
	public static Logger  logger;
	public static WebDriver driver;
	@Parameters("Browser")
	@BeforeMethod	
	public void initialisation(String Browsername)
	{
		logger = logger.getLogger("Maven_project Ecommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if (Browsername.equals("Chrome"))
        {
		System.setProperty("webdriver.chrome.driver", RC.getchromepath());
        driver = new ChromeDriver();
        }
		else if(Browsername.equals("MS Edge"))
	    {
			System.setProperty("webdriver.edge.driver", RC.getedgepath());
	        driver = new EdgeDriver();
	     }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtils.pageload_timeout,TimeUnit.SECONDS);
        driver.get(BaseUrl);

        
	}
	
	
	
	public String getscreenshotAS(String TestCase) throws IOException
	{
		TakesScreenshot TS = (TakesScreenshot) driver;
		
		File Source = TS.getScreenshotAs(OutputType.FILE);
        
		String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date ());
		
		String Destination=System.getProperty("user.dir") + "/Screenshot/"+TestCase+""+TimeStamp+".png";
		
		FileUtils.copyFile(Source, new File(Destination));
		
		return Destination;	
		
	}

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	

}
