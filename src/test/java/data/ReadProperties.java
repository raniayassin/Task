package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static Properties data = readProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\Data.properties");
	private static Properties readProperties(String path)
	{
		Properties properties = new Properties();
		try {
			FileInputStream stream = new FileInputStream(path);
			properties.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}

}
