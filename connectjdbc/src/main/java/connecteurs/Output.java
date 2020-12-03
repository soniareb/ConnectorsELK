package connecteurs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import parserXML.OpenFile;
import parserXML.ParserXMLparametre;

public class Output {

	
	
	 private String tab1="\n  ";
	 private String tab2 = " => ";
	 private FileWriter out ;
	 private boolean editOutput;
	 
 	public Output(FileWriter out,boolean editOutput) {
		this.out=out;
		this.editOutput = editOutput;
	}
	
	
	
	public void setOutput(String path) {

		OpenFile file = new OpenFile(path);
		Element racine = file.getRoot();
		ParserXMLparametre par = new ParserXMLparametre(racine);
		List <String> list =new ArrayList<String>();
		list = par.getInfo();
		 
		 String initialization = "output {\n" + 
		 		"  stdout { codec => json_lines }\n" + 
		 		"  elasticsearch {";
		 
		 String host="\"hosts\""+tab2+"\""+list.get(0)+":"
				 +list.get(1)+"\"";
		 
		 String index ="\"index\" => \""+list.get(2)+"\"";
		 String document_type = "\"document_type\" => \""+list.get(3)+"\"";
		 try {
			 out.write("\n");
			 out.write(initialization+tab1);
			 out.write(host+tab1);
			 out.write(index+tab1);
			 out.write(document_type+tab1);
			 } catch (IOException e) {
				e.printStackTrace();
			}
		 if (editOutput) {
			 Configuration conf = new Configuration(out);
			 conf.setConfiguration("configuration.xml");
		 }
			 try {
				out.write("}\n}");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}

}
