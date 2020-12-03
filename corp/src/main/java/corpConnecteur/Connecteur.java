package corpConnecteur;

import java.util.List;

public interface Connecteur {
	public void Initialize(String file,String nameDirectory);
	public void setInput();
	public void setOutput(String file);
	public boolean testConnecteur();
	public List <String> getEntity ();
	public Composant ElementsSet(String db, String query);
	public void setEditInput(boolean editInput);
    public void seteditOutput(boolean editOutput);
	public void fin();
}
