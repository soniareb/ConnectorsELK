package factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class LoadClass {
	public Class Load(String path, String className) {
		
		URL jar=null;
		Class classToLoad = null;
		
		try {
			jar = new File(path).toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		URL[] jars = {jar};
		URLClassLoader child = new URLClassLoader(jars);
		try {
		 classToLoad = Class.forName(className, true, child);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return classToLoad;
		
		
	}

}
