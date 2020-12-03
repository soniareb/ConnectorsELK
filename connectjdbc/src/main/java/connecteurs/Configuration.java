package connecteurs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import parserXML.OpenFile;
import parserXML.ParserXMLConfig;


public class Configuration {	
	private FileWriter out ;
	 String tab1;
	 String tab2;
	public Configuration(FileWriter out) {
		this.out=out;
		tab1 = "\n    ";
		tab2 = " => ";	
	}
	
	public void setConfiguration(String path){
		
		OpenFile file = new OpenFile(path);
		 Element rasine = file.getRoot();	 
	 	 ParserXMLConfig par = new ParserXMLConfig(rasine);
	 	List<String[]> list = new ArrayList<String[]>();
	 	list = par.getList();
	 	int lang = list.size();
	 	String [] tab ;
	 	System.out.println(lang);
	 	for(int i=0;i<lang;i++) {
	 		tab = list.get(i);
	 		String str= tab[0]+tab2+tab[1]+tab1;
	 		try {
				out.write(str);
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
		
	}

}
