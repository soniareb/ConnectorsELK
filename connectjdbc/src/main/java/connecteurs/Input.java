package connecteurs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input {
	
	
	
	 private List <String> info =new ArrayList<String>();
	 private FileWriter out ;
	 private boolean editInput = false ;
	 private List <String> database =new ArrayList<String>();
	 
	 
	 public Input(List <String> info,FileWriter out,boolean editInput,List <String> database) {
		 this.info=info;
		 this.out=out;
		 this.editInput=editInput;
		 this.database=database;
	 }
	
	
	
	public void setInputMySQL() {
		String tab1 = "\n    ";
		String input = "input {\n  jdbc {";		
		String site="jdbc_connection_string => \""
				+ database.get(0)
				+ "://"+info.get(0)+":"+info.get(1)+"/"+info.get(4)+"\"";
		 String user ="jdbc_user => \""+info.get(2)+"\"";
		 String pwd = "jdbc_password => \""+info.get(3)+"\"";
		 String jdbc_driver ="jdbc_driver_library => \""
		 		+ database.get(1)
		 		+ "\"\n"
				 	 
				 +"    jdbc_driver_class => \""
				 + database.get(2)
				 + "\"";
		 
		 String statement_filepath = "statement_filepath => \"statement_file\"";
		 try {
			
			out.write(input+tab1);
			 out.write(jdbc_driver+tab1);
			out.write(site+tab1);
			 out.write(user+tab1);
			 out.write(pwd+tab1);
			 out.write(statement_filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 if (editInput) {
			 Configuration conf = new Configuration(out);
			 conf.setConfiguration("configuration.xml");
		 }	 
		 try {
			out.write("}\n  }");
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
