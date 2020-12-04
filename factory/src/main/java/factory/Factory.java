package factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import corpConnecteur.Connecteur;

import java.util.Map.Entry;

import registry.Registry;

public class Factory {
	public Connecteur finder(String name) {
		String path;
		String className;
		Connecteur connecteur;
		 Map<String, String> list = new HashMap<String, String>();
		Registry reg = new Registry ();
		 list=reg.getConnecteur(name);
		 
		 
		 Set<Entry<String, String>> setListConnecteur = list.entrySet();
	     Iterator<Entry<String, String>> it = setListConnecteur.iterator();
	         Entry<String, String> e = it.next();
	         path=e.getKey();
	         className = e.getValue();
	        connecteur = new ConnectorCreator(path,className) ;
		
		return connecteur;
	}

}
