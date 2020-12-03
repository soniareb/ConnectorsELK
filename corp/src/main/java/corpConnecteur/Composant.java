package corpConnecteur;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.swt.ole.win32.Variant;

public interface Composant {
	
	public Map<String, String> getElement(ResultSet resultSet);
	public  ArrayList<Map<String, String>> getElementsSet();

}
