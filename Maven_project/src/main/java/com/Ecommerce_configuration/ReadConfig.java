package com.Ecommerce_configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public  ReadConfig()  {
	File src = new File("C:\\Users\\Rahul\\eclipse-workspace\\Maven_project\\src\\main\\java\\com\\Ecommerce_configuration\\config.properties");
	
	FileInputStream fis;
	
	try {
		fis = new FileInputStream(src);
		pro = new Properties() ;
		try {
			pro.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
	
}
	
public String getapplicationUrl()
{
	String url = pro.getProperty("BaseUrl");
	return url;
	
}

public String getchromepath()
{
	String CD = pro.getProperty("Chromedriver");
	return CD;
	
}
public String getedgepath()
{
	String ED = pro.getProperty("Edgedriver");
	return ED;
	
}

public String getFirstname() {
	String FN = pro.getProperty("FN");
	return FN;	
}

public String getLastName() {
	String LN = pro.getProperty("LN");
	return LN;	
}

public String getEmail() {
	String UN = pro.getProperty("UN");
	return UN;	
}

public String getPassword() {
	String PW = pro.getProperty("PW");
	return PW;	
}

public String getSearch() {
	String search = pro.getProperty("search");
	return search;	
}



public String getConfirmPassword() {
	String CPW = pro.getProperty("CPW");
	return CPW;	
}






}
