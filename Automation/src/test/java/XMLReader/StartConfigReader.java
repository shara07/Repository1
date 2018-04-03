package XMLReader;
import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StartConfigReader {
	Document document;
	HashMap<String, ObjectRepro> map = null;
	TestSuite testSuite;
	
	public TestSuite getTestSuite() {
		return testSuite;
	}

	public void setTestSuite(TestSuite testSuite) {
		this.testSuite = testSuite;
	}

	public StartConfigReader()
	{
		this.setTestSuite(new TestSuite());
	}

	
	
	
	public void getRootElement()
	{
		//File bootFile =  new File("C:\\Users\\nshekhar\\Desktop\\XMLFileReader_2_11-17-2017\\AccidentFundXmlReader\\src\\StartUpConfig.xml");
		//File bootFile =  new File("C:\\Automation\\Selenium\\TestFlowBotSelenium\\src\\XMLReader\\StartUpConfig.xml");
		File bootFile =  new File("C:\\TestNgwithMaven\\Automation\\src\\test\\java\\XMLReader\\StartUpConfig.xml");
		Document doc = null ;
		try
		{
			 //xmlFile = new File("C:\\Selenium_BC31102017\\TestFlowBotSelenium\\ObjectRef.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	//doc = dBuilder.parse(xmlFile);
	    	doc = dBuilder.parse(bootFile);
	    	doc.getDocumentElement().normalize();	    	
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		document  = doc;
	}
	
	public void setProperties()
	{
		NodeList testSuite = document.getElementsByTagName("TestSuite");
	    for (int temp = 0; temp < testSuite.getLength(); temp++) {
	        Node nNode = testSuite.item(temp);
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            
	            		this.testSuite.setTestSuiteName(eElement.getAttribute("name"));
			            this.testSuite.setTestSuitePath(eElement.getAttribute("path"));
			            this.testSuite.setBrowser(eElement.getAttribute("Browser"));
			            this.testSuite.setUrlAddress(eElement.getAttribute("Url"));
			            this.testSuite.setMaximise(eElement.getAttribute("Maximise"));
	        }
	    }		
	}
}
