package directory;

import java.io.File;

public class CreateDirectory {
	
	public CreateDirectory(String path) {

File theDir = new File(path);

// if the directory does not exist, create it
if (!theDir.exists()) {
    try{
        theDir.mkdir();}
    
    catch(SecurityException se){
        se.getMessage();}        

}

else System.out.println("directory exist");
		

	}
}
