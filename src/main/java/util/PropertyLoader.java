package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
	private static Properties properties = new Properties();

	static {
        try (InputStream input = PropertyLoader.class.getClassLoader().getResourceAsStream("project.properties")) {            
        	properties.load(input);		            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
