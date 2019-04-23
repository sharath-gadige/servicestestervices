package com.bighalf.service.datasquare.util;

import java.io.InputStream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * class used to load the log4j configurations
 * 
 * @author Mateen, Big Half.
 * Jul 13, 2015
 * @version 1.0
 *
 */

public class Log4jLoder {
	private Log4jLoder(){}
	
	private static Log4jLoder log4jLoder = new Log4jLoder();
	
	/**
	 * method used to get Log4jloder object
	 * @return
	 */
	public static Log4jLoder getLog4jLoder(){
		return log4jLoder;
	}
	
	/**
	 * method used to initialize log4j logging
	 * @return boolean result value specifying log4j logging has been initialized or not
	 */
	public boolean initilializeLogging(){
		boolean result=false;
		try {
			InputStream inputStream=this.getClass().getResourceAsStream("/log4j.properties");
			if(null==inputStream){
				System.out.println("log4j.propertie's not found");
				BasicConfigurator.configure();
			}else{
				System.out.println("log4j.propertie's found.");
				PropertyConfigurator.configure(inputStream);
			}
			Logger logger = Logger.getLogger(Log4jLoder.class);
			logger.debug("Log4j Initialized");
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error initilializing log4j");
		}
		return result;
	}
	
	/**
	 * clone method has been overridden so that this class object cannot be cloned
	 */
	@Override
	public Object clone(){
		return log4jLoder;
	}

}