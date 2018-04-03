package XMLReader;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestStepReader {
	File fXmlFile;
	Document document;
	ArrayList<TestStep> ListOfTestStep = null;
	
	public ArrayList<TestStep> getListOfTestStep() {
		return ListOfTestStep;
	}

	public void setListOfTestCase(ArrayList<TestStep> listOfTestStep) {
		ListOfTestStep = listOfTestStep;
	}

	public TestStepReader(File _file)
	{
		this.fXmlFile = _file;
		ListOfTestStep = new ArrayList<TestStep>();
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
		NodeList nNodes = document.getElementsByTagName("Step");	
			
	    for (int count = 0; count < nNodes.getLength(); count++) {
	        Node nNode = nNodes.item(count);
	        TestStep testStep = new TestStep();
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            
	            testStep.setKeyword(eElement.getAttribute("Keyword"));
	            testStep.setObjref(eElement.getAttribute("Objref"));
	            testStep.setObjrefValue(GetObjectRef(testStep.Objref));            
	            testStep.setData1(eElement.getAttribute("Data1"));
	            testStep.setData2(eElement.getAttribute("Data2"));
	           // System.out.println(""+testStep);
	            ListOfTestStep.add(testStep);
	        }
	    }
	    
	    this.setListOfTestCase(ListOfTestStep);
	}
	
	public String GetObjectRef(String objRef)
	{
		NodeList nodes = document.getElementsByTagName("object_repro");
		Element eElement = (Element) nodes.item(0);
		String objectRefValue = "";
		if(eElement.getAttribute("Name") != null && eElement.getAttribute("Path") != null)
		{
			File f = new File(eElement.getAttribute("Path"), eElement.getAttribute("Name"));
			
			ObjectReproReader objectReproReader = new ObjectReproReader(eElement.getAttribute("PageName"), objRef);
			objectReproReader.getRootElement(f);
			objectReproReader.setProperties();
			objectRefValue = objectReproReader.getObjectRefValue();
			objectReproReader = null;
		}
		
		return objectRefValue;
	}
	
}
