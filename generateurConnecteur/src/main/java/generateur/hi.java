package generateur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class hi {

	public static void main(String[] args) {
		        String s;
		        Process p;
		        try {
		            p = Runtime.getRuntime().exec("ls; ls");
		            BufferedReader br = new BufferedReader(
		                new InputStreamReader(p.getInputStream()));
		            while ((s = br.readLine()) != null)
		                System.out.println("line: " + s);
		            p.waitFor();
		            System.out.println ("exit: " + p.exitValue());
		            p.destroy();
		        } catch (Exception e) {}
		    }		
	}