package parserXML;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXMLparametre {
	
	
	private List <String> info =new ArrayList<String>();
	public List<String> getInfo() {
		return info;
	}
	public ParserXMLparametre(Element n) {
		 String str = new String();
	          
	         int nbChild = n.getChildNodes().getLength();
	         NodeList list = n.getChildNodes();
	         
	         for(int i = 0; i < nbChild; i++){
	        	 i++;
	            Node n2 = list.item(i);
	            str = Next(n2);
	            info.add(str);         
	         }
	}
	
	
	public String Next (Node n) {
		String contenue="";
		if (n instanceof Element){
        	if(n.getChildNodes().getLength() == 1)
                contenue = n.getTextContent();
        }
		return contenue;
	}


}
