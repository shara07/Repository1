package XMLReader;
import java.io.File;
import java.util.ArrayList;

public class MainTestSuite
{
	public TestSuite getMainTestSuite()
	{
		StartConfigReader configReader = new StartConfigReader();
		configReader.getRootElement();
		configReader.setProperties();
		
		TestSuite mainTestSuite =  configReader.getTestSuite();		
		String testSuiteName = mainTestSuite.getTestSuiteName() + ".xml";
		String testSuitePath = mainTestSuite.getTestSuitePath();
		
		File testSuite =  new File(testSuitePath, testSuiteName);
		
		TestSuiteReader reader = new TestSuiteReader(testSuite);
		reader.getRootElement();
		reader.setProperties();	
		
		mainTestSuite.testCases = reader.getListOfTestCase();
		
		//Object testcases;
		for(TestCase testCase: mainTestSuite.testCases)
		{
			if(testCase.getExecutionStatus().equals("Yes"))
			{
				File testStepPath =  new File(testCase.getPath(), testCase.getName() + ".xml");
				TestStepReader testStepReader = new TestStepReader(testStepPath);
				testStepReader.getRootElement();
				testStepReader.setProperties();
				
				ArrayList<TestStep> ListOfTestStep = testStepReader.getListOfTestStep();
				testCase.testSteps = ListOfTestStep;				
			}
		}
		
		return mainTestSuite;		
	}
	
	public ArrayList<TestStep> getTestSteps(String testCasePath, String testCaseName){
		File testStepPath =  new File(testCasePath, testCaseName+ ".xml");
		TestStepReader testStepReader = new TestStepReader(testStepPath);
		testStepReader.getRootElement();
		testStepReader.setProperties();
		
		ArrayList<TestStep> ListOfTestStep = testStepReader.getListOfTestStep();
		return ListOfTestStep;
	}
	 		

}



