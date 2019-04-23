package com.bighalf.service.datasquare.util;

import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * 
 * @author Apurva
 * Jan 2 2016
 */

public class PropertiesLoader {
	
	private static Logger logger = Logger.getLogger(PropertiesLoader.class);
	
	private static PropertiesLoader propertiesLoader = new PropertiesLoader();
	
	public static PropertiesLoader getPropertiesLoader(){
		return propertiesLoader;
	}
	/**
	 * method used to load project.properties file
	 * @return boolean result value loading project.properties file
	 */
	public boolean loadProjectProperties(){
		boolean result=false;
		try {
			InputStream inputStream=this.getClass().getResourceAsStream("/project.properties");
			PropertyManager.getPropertyManager().getProperties().load(inputStream);
			Logger logger = Logger.getLogger(Log4jLoder.class);
			logger.debug("project.properties file loaded");
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error loading project.properties file");
			System.exit(0);
		}
		return result;
	}
}

