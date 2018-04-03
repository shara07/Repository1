package SeleniumAutomation;
//package XMLReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import XMLReader.MainTestSuite;
import XMLReader.TestCase;
import XMLReader.TestStep;
import XMLReader.TestSuite;

public class Executer {

	TestSuite testSuite;
	WebDriver webDriver = null;
	ArrayList<TestCase> testCases;
	ArrayList<TestStep> testSteps,childTestSteps;
	MainTestSuite mainTestSuite;
	Class<KeywordManager> keyManager;
	Object o;
	public   HashMap<String, String> hmap = new HashMap<String, String>();
	public Executer(){
		mainTestSuite = new MainTestSuite();
		testSuite = mainTestSuite.getMainTestSuite();
		hmap.put("suitename", testSuite.getTestSuiteName());		
		getDriver(testSuite.getBrowser().toLowerCase(), testSuite.getMaximise());
	}
	
	
	public void getDriver(String browserType, String maximise)
	{
		if(browserType.equals("firefox"))
		{
			webDriver = new FirefoxDriver();
		}
		if(browserType.equals("chrome"))
		{
			webDriver = new ChromeDriver();
		}
		
		if(browserType.equals("ie"))
		{
			DesiredCapabilities dc=new DesiredCapabilities();			
			dc.setBrowserName("internet explorer");
			dc.setPlatform(Platform.WINDOWS);
			//webDriver = new InternetExplorerDriver(dc);
			webDriver =  new InternetExplorerDriver();
		}
		
		if(maximise.equals("true"))
		{
			webDriver.manage().window().maximize();
		}
		webDriver.get(testSuite.getUrlAddress());
		webDriver.manage().window().maximize();
		webDriver.navigate();
		webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
	}
	
	public void Execute() throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		ReportFunctions function = new ReportFunctions();		
		testCases = (ArrayList<TestCase>) testSuite.getTestCases();
		keyManager = KeywordManager.class;
		o= keyManager.newInstance();
		
		for(TestCase testCase: testCases)
		{
			hmap.put("Tcase", testCase.getName());
			testSteps = (ArrayList<TestStep>) testCase.getTestSteps();
			for(TestStep step: testSteps)
			{
				try{
					hmap.put("Tstep", step.getKeyword());					
					Method[] allMethods = keyManager.getDeclaredMethods();
					for (Method m : allMethods) {
						String mname = m.getName();
						if(mname.equals(step.getKeyword()))
						{
							m.invoke(o, webDriver, step, hmap);
							break;
						}
						
						if(step.getKeyword().toLowerCase().equals("run"))
						{
							Run(step);
							break;
						}
					}			
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
	}
	
	public void Run(TestStep testStep){
		
		String filePath = testStep.getObjref();
		String filename = testStep.getData1();
		
		childTestSteps = mainTestSuite.getTestSteps(filePath, filename);
						
		for(TestStep step: childTestSteps)
		{
			try{
				hmap.put("Tstep", step.getKeyword());					
				Method[] allMethods = keyManager.getDeclaredMethods();
				for (Method m : allMethods) {
					String mname = m.getName();
					if(mname.equals(step.getKeyword()) && (step != null))
					{
					m.invoke(o, webDriver, step, hmap);
						break;
					}
					
					if(step.getKeyword().toLowerCase().equals("run"))
					{
						Run(step);
						break;
					}
				}			
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}		
	}
}
