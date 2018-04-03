package XMLReader;
import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ObjectReproReader {
	File fXmlFile;
	Document document;
	HashMap<String, ObjectRepro> map = null;
	String PageName;
	String ObjectRef;
	String ObjectRefValue;
	public String getPageName() {
		return PageName;
	}
	public void setPageName(String pageName) {
		PageName = pageName;
	}
	public String getObjectRef() {
		return ObjectRef;
	}
	public void setObjectRef(String objectRef) {
		ObjectRef = objectRef;
	}
	public String getObjectRefValue() {
		return ObjectRefValue;
	}
	public void setObjectRefValue(String objectRefValue) {
		ObjectRefValue = objectRefValue;
	}

	
	public ObjectReproReader(String _pageName, String _objectRef)
	{
		this.PageName = _pageName;
		this.ObjectRef = _objectRef;
	}
	
	public ObjectReproReader(String _pageName)
	{
		this.PageName = _pageName;
	}
	
	public void getRootElement(File xmlFile)
	{
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	document = dBuilder.parse(xmlFile);
	    	document.getDocumentElement().normalize();	    	
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void setProperties()
	{
		NodeList pageNodes = document.getElementsByTagName("PageNode");
		
	    for (int count = 0; count < pageNodes.getLength(); count++) {
	        Node nNode = pageNodes.item(count);	        
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;	            
	            if(eElement.getAttribute("Name").equals(this.PageName)){         
	            	NodeList nodes = eElement.getElementsByTagName("Object");
	            	for (int index = 0; index < nodes.getLength(); index++){
	            		Node oNode = nodes.item(index);
	            		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	            Element oElement = (Element) oNode;	        	            
	        	            if(oElement.getAttribute("objref").equals(this.ObjectRef)){
	        	            	this.setObjectRefValue(oElement.getAttribute("value"));
	        	            }
	            		}
	            	}
	            }
	        }
	    }
	}

}
