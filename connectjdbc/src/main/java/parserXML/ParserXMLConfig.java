package parserXML;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXMLConfig {
	private List<String[]> ListArray = new ArrayList<String[]>();

	public List<String[]> getList() {
		return ListArray;
	}
	
	public ParserXMLConfig (Element n){
		String str = new String();     
		int nbChild = n.getChildNodes().getLength();
		NodeList list = n.getChildNodes();
		for(int i = 0; i < nbChild; i++){
		        	 i++;
		            Node n2 = list.item(i);
		            String[] element = new String[2];
		            if (n2 instanceof Element){ 
		            	str = n2.getNodeName();
		            	element[0]=str;
				        str =n2.getTextContent();
				        element[1]=str;
				        ListArray.add(element);
		            }
		         }}
	
	
	
	public List<String> toList()  {
		List<String> List = new ArrayList<String>();
		   ListIterator<String[]> it = ListArray.listIterator();
		      while(it.hasNext()){
		    	  String[] el = new String[2];
		    	  el = it.next();
		    	  List.add(el[0]);
		    	  List.add(el[1]);
	}
		      return List;
	}


}
