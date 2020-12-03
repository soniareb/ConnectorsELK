package connecteurs;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import parserXML.OpenFile;
import parserXML.ParserXMLparametre;

public class Databases {
	
	
	
	public ArrayList<String> getdatabase(String dataBase) {
		List <String> database =new ArrayList<String>();
		OpenFile OpenFile = new OpenFile(dataBase);
		Element root = OpenFile.getRoot();
		ParserXMLparametre parser = new ParserXMLparametre(root);
		database = parser.getInfo();
		return (ArrayList<String>) database;
		
	}

}
