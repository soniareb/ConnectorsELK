package factory;

import corpConnecteur.Connecteur;

public class test {

	public static void main(String[] args) {
		
		Factory fac = new Factory();
		Connecteur con = fac.getConnecteur("mysql");
		
		
		
		//ConnectorCreator con = new ConnectorCreator("/home/sonia/Bureau/jdbc.jar", "connecteurMySQL.ConnecteurMySQL");
	    con.Initialize("input.xml", "bonjour");
	     con.setInput();
	     con.fin();
	}

}
