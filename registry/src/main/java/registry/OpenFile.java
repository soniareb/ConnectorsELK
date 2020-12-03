package registry;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OpenFile {
	
	static final String FILEPATH = "path";
	 private  JSONObject jsonObject;
	  private JSONArray connecteurs ;
	
	 public JSONObject getJsonObject() {
			return jsonObject;
		}
	 
	public JSONArray getConnecteurs() {
		return connecteurs;
	}

	public  OpenFile() {
		JSONParser parser = new JSONParser();
		 Object obj=null;
			try {
				obj = parser.parse(new FileReader(FILEPATH));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		   jsonObject = (JSONObject) obj;
		   connecteurs = (JSONArray) jsonObject.get("connecteurs");
	}
}

