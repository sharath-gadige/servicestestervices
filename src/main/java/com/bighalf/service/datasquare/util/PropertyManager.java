package com.bighalf.service.datasquare.util;

import java.util.Properties;

/**
 * 
 * @author Apurva
 * Jan 2 2016
 */

public class PropertyManager {
	
	private PropertyManager(){}
	
	private static PropertyManager propertyManager = new PropertyManager();
	
	public static PropertyManager getPropertyManager(){
		return propertyManager;
	}
	
	private Properties properties = new Properties();
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public static String getProperty(String key, String defaultValue){
		return propertyManager.getProperties().getProperty(key,defaultValue);
	}

}


