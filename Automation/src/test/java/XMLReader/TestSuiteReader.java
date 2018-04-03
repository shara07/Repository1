package XMLReader;

import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestSuiteReader {
	
	File fXmlFile = null;
	Document document = null;
	ArrayList<TestCase> ListOfTestCase = null;
	
	public ArrayList<TestCase> getListOfTestCase() {
		return ListOfTestCase;
	}

	public void setListOfTestCase(ArrayList<TestCase> listOfTestCase) {
		ListOfTestCase = listOfTestCase;
	}

	public TestSuiteReader(File _file)
	{
		this.fXmlFile = _file;
		ListOfTestCase = new ArrayList<TestCase>();
	}
	
	public void getRootElement()
	{
		try
		{
			 //xmlFile = new File("C:\\Selenium_BC31102017\\TestFlowBotSelenium\\ObjectRef.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	document = dBuilder.parse(this.fXmlFile);
	    	document.getDocumentElement().normalize();	    	
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}		
	}
	
	public void setProperties()
	{
		NodeList testCases = document.getElementsByTagName("Testcase");
		
	    for (int count = 0; count < testCases.getLength(); count++) {
	        Node nNode = testCases.item(count);
	        TestCase testcase =  new TestCase();
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            if(eElement.getAttribute("ExecutionStatus").equals("Yes"))
	    		{
	            	testcase.setName(eElement.getAttribute("Name"));
		            testcase.setPath(eElement.getAttribute("Path"));
		            testcase.setApplcationName(eElement.getAttribute("ApplcationName"));
		            testcase.setExecutionStatus(eElement.getAttribute("ExecutionStatus"));
		            ListOfTestCase.add(testcase);				
	    		}
	        }
	    }
	    
	    this.setListOfTestCase(ListOfTestCase);    
	    
	}
}
