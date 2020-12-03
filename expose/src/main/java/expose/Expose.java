package expose;

import java.io.File;

public class Expose {

	public void AddJar(String pathJar ,String pathSource){
	 	   File afile =new File(pathJar); 		
	 	   if(afile.renameTo(new File(pathSource+afile.getName()))){
	 		System.out.println("File is moved successful!");
	 	   }else{
	 		System.out.println("File is failed to move!");
	 	   }
		}

}
