package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.FindBy;

public class PostBodyUtil {
	static String dir = System.getProperty("user.dir");
	String filepath;
	
	public PostBodyUtil(String filepath) {
		this.filepath=filepath;
	}
	public File postBodyPreparation(LinkedHashMap<String, String>hm) {
		Date date = new Date();
		String newfilePath= dir+"/generatedfiles/"+date.getTime()+"new.json";
		File fileToBeModified = new File(filepath);
		File newFileGenerated = new File(newfilePath);
//		File file = new File("path to file");
		File file = new File(filepath);
		FileInputStream fis;
		try {
			FileReader fs = new FileReader(file);
			String newString = "";

			BufferedReader br = new BufferedReader(fs);
			String line = null;
			int count = 0;
			while ((line = br.readLine()) != null) { 
				newString = newString+line+"\n";
			}
			br.close();
			
			for(java.util.Map.Entry<String, String> e:hm.entrySet()) {
				newString = newString.replace(e.getKey(), e.getValue());
			}
			System.out.println(newString);
			PrintWriter pw = new PrintWriter(newfilePath);
//			String st= newString;
			pw.write(newString);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFileGenerated;
	}
	

        
        
	
}
