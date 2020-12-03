package directory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseInstance {
	private File current;
	private FileInputStream filesource=null;
    private FileOutputStream fileDestination=null;
    private File[] list;
             
	        public UseInstance (String path) {
	        current = new File(path);     
		if (current.isDirectory()) {
			list = current.listFiles();
			if (list != null) {
				for (int i = 0; i < list.length; i++) {
		        try{
		            filesource=new FileInputStream(path+"/"+ list[i].getName());
		            fileDestination=new FileOutputStream("/home/sonia/Téléchargements/ELK/logstash-6.2.4/"+ list[i].getName());
		            byte buffer[]=new byte[512*1024];
		            int nblecture;
		            while((nblecture=filesource.read(buffer))!=-1){
		                fileDestination.write(buffer,0,nblecture);
		            }
		        }catch(FileNotFoundException nf){
		            nf.printStackTrace();
		        }catch(IOException io){
		            io.printStackTrace();
		        }finally{
		            try{
		                filesource.close();
		            }catch(Exception e){
		                e.printStackTrace();
		            }
		            try{
		                fileDestination.close();
		            }catch(Exception e){
		                e.printStackTrace();
		            }
		        } 		
		
				}	
			}
	}	
	}	
}