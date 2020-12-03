package parserXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class OpenFile {
	
	
	
	private Element root;
	public Element getRoot() {
			return root;
		}
	public OpenFile(String file) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
		    File fileXML = new File(file);
		    Document xml;
		    try {
		    	xml = builder.parse(fileXML);
		        root = xml.getDocumentElement();
		        } catch (SAXParseException e) { }
		      } catch (ParserConfigurationException e) {
		         e.printStackTrace();
		      } catch (SAXException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }	
		}


}
