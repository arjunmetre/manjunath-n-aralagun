package edu.college.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropertiesUtil {

	private static PropertiesUtil util = null;
	private Properties prop = new Properties(); 

	
	private PropertiesUtil() {
		try {
			load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void load() throws IOException {
		 //InputStream is = new FileInputStream("dbconfig.properties");
		InputStream is = this.getClass().getResourceAsStream("dbconfig.properties");
		prop.load(is);
	}

	
	public static String get(String key) {
		if (util == null)
			util = new PropertiesUtil();
		return util.prop.getProperty(key);
	}
}