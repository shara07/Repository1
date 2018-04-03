package SeleniumAutomation;

import java.util.HashMap;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;

import SeleniumAutomation.KeywordManager;
import XMLReader.TestStep;;

public class AppScript extends KeywordManager
{
	/*SeleniumAutomation.CommonFunctions COMMON = new CommonFunctions();*/
	
	
	private static WebDriver webdriver;
	public static boolean  AccountLogin(WebDriver WebDriver, TestStep step, HashMap<String, String> hmap){
		boolean flag = true;
		KeywordManager keyword = new KeywordManager();
		try{
			//String parameters = null;
			keyword.EnterValue(WebDriver, step, hmap);
		/*	CommonFunctions.Click(WebDriver, "Gmail=>Login=>Next=>Button", data1);
			CommonFunctions.EnterValue(WebDriver, "Gmail=>Login=>Password=>TextBox", "password", "password");
			CommonFunctions.Click(WebDriver, "Gmail=>Login=>PasswordNext=>Button", data1, data2);*/
			
		}
		catch(Exception e){
			flag = false;
		}
		return flag;
	}
	public static boolean  RUNSCRIPT(WebDriver WebDriver,String parameters )
	{
		return false;
		
	}
}