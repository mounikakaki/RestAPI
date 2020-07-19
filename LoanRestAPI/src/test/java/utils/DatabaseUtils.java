package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseUtils {
	static Properties prop = new Properties();
	static String directory = System.getProperty("user.dir");
	static File file= new File(directory+"/src/test/resources/Property/Config.properties");
	static FileInputStream fis;
//	public static void main(String[] args) {
//		System.out.println(getDriver());
//	}
	public static String getDriver() {
		try {
			
			fis = new FileInputStream(file);
			prop.load(fis);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		String DbDriver=prop.getProperty("DBDriver");
		return DbDriver;
	}
		
		public static String getDBurl() {
			try {
				
				fis = new FileInputStream(file);
				prop.load(fis);
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			String DBurl=prop.getProperty("DBurl");
			return DBurl;
	}
	
		public static String getDBUsername() {
			try {
				
				fis = new FileInputStream(file);
				prop.load(fis);
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			String DBUsername=prop.getProperty("DBUsername");
			return DBUsername;
	}
		public static String getDBPassword() {
			try {
				
				fis = new FileInputStream(file);
				prop.load(fis);
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			String DBPassword=prop.getProperty("DBPassword");
			return DBPassword;
	}
	

}
