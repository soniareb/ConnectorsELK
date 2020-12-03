package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import corpConnecteur.Composant;
import corpConnecteur.Connecteur;

public class ConnectorCreator implements Connecteur{
	Class classToLoad ;
	Object MyClassObj;
	Constructor MyClassConstruct;
	private Object result;
	
	public ConnectorCreator(String path, String className) {
		LoadClass loader = new LoadClass();
		classToLoad = loader.Load(path, className);
		
		try {
			MyClassConstruct = classToLoad.getConstructor();
			MyClassObj= MyClassConstruct.newInstance(); 
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	public void Initialize(String arg0, String arg1) {
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("Initialize",new Class[] {String.class,String.class});
			result = method.invoke(MyClassObj,arg0,arg1);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	public void fin() {
		Method method;
			try {
				method = classToLoad.getDeclaredMethod("fin");
				result = method.invoke(MyClassObj);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	}

	public Composant getElement(String arg0) {
	
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("getElement",new Class[] {String.class});
			result = method.invoke(MyClassObj,arg0);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
		return (Composant) result;
	}

	
	
	
	
	public List<String> getEntity() {	
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("getEntity");
			result = method.invoke(MyClassObj);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (List<String>) result;
	}

	
	
	
	public void setEditInput(boolean arg0) {
		
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("setEditInput",new Class[] {boolean.class});
			result = method.invoke(MyClassObj,arg0);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
	}

	
	
	
	public void setInput() {
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("setInput");
			result = method.invoke(MyClassObj);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
	}

	
	
	
	
	public void setOutput(String arg0) {
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("setOutput",new Class[] {boolean.class});
			result = method.invoke(MyClassObj,arg0);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	public void seteditOutput(boolean arg0) {
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("seteditOutput",new Class[] {boolean.class});
			result = method.invoke(MyClassObj,arg0);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
	}

	
	
	
	public boolean testConnecteur() {
		Method method;
		try {
			method = classToLoad.getDeclaredMethod("testConnecteur");
			result = method.invoke(MyClassObj);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (Boolean) result;
	}
}
