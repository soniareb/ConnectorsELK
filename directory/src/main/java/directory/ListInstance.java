package directory;

import java.io.File;
import java.util.ArrayList;

public class ListInstance {
	
	 private File repertoire;
     private File[] list ;
     private ArrayList<String> listName = new ArrayList<String>();
     
	public ListInstance(String path) {
		
		repertoire = new File(path);
	     list = repertoire.listFiles();
		
	        if (list != null) {         
	            for (int i = 0; i < list.length; i++) {
	            	if(list[i].isDirectory ( ) )
	            		listName.add(list[i].getName());
	            }
	        }
	        else {
	            System.err.println("Nom de repertoire invalide");
	        }
	}

	public ArrayList<String> getListName() {
		return listName;
	}
	
	
	

}
