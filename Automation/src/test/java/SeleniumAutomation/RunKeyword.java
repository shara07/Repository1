package SeleniumAutomation;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;

import XMLReader.TestStep;

public class RunKeyword {
	
	KeywordManager keywordmanager = new KeywordManager();
	public void run()
	{
		WebDriver WebDriver = null;
		TestStep step = null;
		HashMap<String, String> hmap = null;
		try {
/*			keywordmanager.EnterValue(WebDriver WebDriver, TestStep step, HashMap<String, String> hmap);
*/		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
