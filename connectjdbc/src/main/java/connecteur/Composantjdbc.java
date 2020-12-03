package connecteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import corpConnecteur.Composant;

import com.mysql.jdbc.ResultSetMetaData;

public class Composantjdbc implements Composant{
	
	
	private ResultSet rs;
	ResultSetMetaData resultMeta; 
	
	
	public Composantjdbc() {
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	

	public Map<String, String> getElement(ResultSet resultSet) {
		Map<String, String> element = new HashMap<String, String>();
		String column;
		String value;
		
		 try {
			 resultMeta =(ResultSetMetaData) resultSet.getMetaData();
			for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
				 column = resultMeta.getColumnName(i).toUpperCase();
					if(resultSet.getObject(i)!= null)
						value = resultSet.getObject(i).toString();
				        	else 
				        		value= "null";
					element.put(column,value);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}

	public ArrayList<Map<String, String>> getElementsSet() {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		 try {
			while(rs.next()){
				 list.add(getElement(rs));
			      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}