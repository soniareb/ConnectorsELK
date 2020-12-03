package connecteur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import connecteurs.Databases;
import connecteurs.Input;
import connecteurs.Output;
import connecteurs.statementfil;
import corpConnecteur.Composant;
import corpConnecteur.Connecteur;

import java.sql.DatabaseMetaData;


import directory.CreateDirectory;
import parserXML.OpenFile;
import parserXML.ParserXMLparametre;

public class Connecteurjdbc implements Connecteur{
	private List <String> info =new ArrayList<String>();
	 private File outputFile ;
	 private File statementFile;
	 private FileWriter out ;
	 private FileWriter outstat ;
	 private boolean editInput = false ;
	 private boolean editOutput = false ;
	 private Connection con;
	 private List <String> database =new ArrayList<String>();
	
	
	 
	 public void chooseDatabase (String databaseName) {
		 Databases databases = new Databases();
		 database= databases.getdatabase(databaseName);
	 }
	 
	 public void Initialize(String file, String nameJob) {	
		 CreateDirectory dir = new CreateDirectory("/etc/*****/Jobs/"+nameJob);
			outputFile = new File("/etc/******/Jobs/"+nameJob+"/logstash.conf");
			statementFile = new File("/etc/*********/Jobs/"+nameJob+"/statement_file");
			try {
				out = new FileWriter(outputFile);
				outstat = new FileWriter(statementFile);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			OpenFile OpenFile = new OpenFile(file);
			Element root = OpenFile.getRoot();
			ParserXMLparametre parser = new ParserXMLparametre(root);
			info = parser.getInfo();
		}
	 
	 public void setstat(String query) {
		 statementfil stat = new statementfil(outstat);
		 stat.setStatement(query);
		}
	 
	 
	 //possibilité de modifier les parametre du logstash
	 public void setEditInput(boolean editInput) {
			this.editInput = editInput;
		}

		public void seteditOutput(boolean editOutput) {
			this.editOutput = editOutput;
		}
		

	public void setInput() {
		Input input = new Input(info,out,editInput,database);
		input.setInputMySQL();
		
	}

	public void setOutput(String file) {
		Output output = new Output( out, editOutput);
		output.setOutput(file);
		
	}
	
	public void fin() {
		try {
			out.close();
			outstat.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	//tester la connection etablie ou pas
	public boolean testConnecteur() {
		boolean test = false;
		String path ="jdbc:mysql://"+info.get(0)+":"+info.get(1)+"/"+info.get(4);
		String user =info.get(2);
		String pwr =info.get(3);
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(path,user,pwr);  
			test=true;
			}catch(Exception e){ System.out.println(e);}
		return test;
	}

	
	// dans le cas du MySQL return la liste des tab
	//entity 
	public List<String> getEntity () {
		
		List <String> tables =new ArrayList<String>();
		try{  
			DatabaseMetaData md = (DatabaseMetaData) con.getMetaData();
			ResultSet rs = (ResultSet) md.getTables(null, null, "%", null);
			while (rs.next()) {
				tables.add(rs.getString(3));
			}
			}catch(Exception e){ System.out.println(e);}
		
		return tables;
	}

	
	//dans le cas de Mysql return les tuples
	public Composant ElementsSet(String db, String query) {
		Composantjdbc composants  =new Composantjdbc();
			Statement stmt;
			try {
				stmt = (Statement) con.createStatement();
			//	System.out.println(query+"from "+db+"; ");
				ResultSet rs=stmt.executeQuery(query+" from "+db+"; "); 
				
				composants.setRs(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}  
		return composants;
}
}
