package registry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Registry {
	private JSONArray connecteurs;
	
	static final String FILEPATH = "path";
	JSONObject jsonObject;
	JSONObject obj = new JSONObject();
	FileWriter file;

	
	
	
	public Registry() {
		OpenFile open = new OpenFile();
	    connecteurs = open.getConnecteurs();
		jsonObject=open.getJsonObject();
	}
	
	
	
	public void AddConnector(String name, String path , String className) {
		
		 connecteurs = (JSONArray) jsonObject.get("connecteurs");
			
			obj.put("Name", name);
			obj.put("Path", path);
			obj.put("ClassName", className);
			connecteurs.add(obj);
			jsonObject.put("connecteurs", connecteurs);
		
			
				try {
					file = new FileWriter(FILEPATH);
					file.write(jsonObject.toJSONString());
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	
	public ArrayList<String> listConnecteur (){
		ArrayList<String> list = new ArrayList<String>();
		
		
		 Iterator<JSONObject> iterator = connecteurs.iterator();
         while (iterator.hasNext()) {
         	
         	 JSONObject record = iterator.next();
	            System.out.println(record);

	           String name = (String) record.get("Name");
	            System.out.println(name);
	            list.add(name);
         }
		return list;}
	
	
	
	public Map<String, String> getConnecteur (String nameConnecteur){
		
		String className = null;
		 boolean test=false;
		 String path = null;	
		 Iterator<JSONObject> iterator = connecteurs.iterator();
		 Map<String, String> list = new HashMap<String, String>();
		 
			
         while (iterator.hasNext() && !test) {
         	
         	 JSONObject record = iterator.next();
	           String name = (String) record.get("Name");
	           if(name.equals(nameConnecteur)) {
	        	   test=true;
	             path = (String) record.get("Path");
	             className = (String) record.get("ClassName");
	             list.put(path, className);
	           }	            
         }
		return list;
	}
	
	public void removeConnecteur (String nameConnecteur) {}

}
