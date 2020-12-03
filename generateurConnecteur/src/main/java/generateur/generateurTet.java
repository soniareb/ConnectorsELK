package generateur;

import connecteurMySQL.ConnecteurMySQL;
import connecteurMySQL.connecteurTest;
import corpConnecteur.Connecteur;
import registry.Registry;

public class generateurTet {

	public static void main(String[] args) {
		ConnecteurMySQL conn = new ConnecteurMySQL("SQL");
		Registry.addConnecteur("SQL", conn);
		
		
		connecteurTest conncteur = new connecteurTest();
		Registry.addConnecteur("test", conncteur);
		
		ConnecteurMySQL connection =(ConnecteurMySQL) Registry.getConnecteur("SQL");
		Registry.listConnecteur();
		System.out.println(connection);

	}

}
