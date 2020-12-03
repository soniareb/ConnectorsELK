package connecteurs;

import java.io.FileWriter;
import java.io.IOException;

public class statementfil {
	private FileWriter out;
	
	public statementfil (FileWriter out ) {
		this.out=out;
		
	}
	public void setStatement(String statement) {
	 try {
			out.write(statement);
		} catch (IOException e) {
			e.printStackTrace();
		}}

}
