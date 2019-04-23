package com.bighalf.spark.helpers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.bighalf.service.datasquare.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.jaxrs.config.BeanConfig;

public class DatasquaresUtil {
	
	private static final Logger LOGGER = Logger.getLogger(DatasquaresUtil.class); 
	
	public static ObjectMapper objectMapper = new ObjectMapper();
	public static Map<Integer, String> errorStatusCodes = new HashMap<Integer, String>();

	// SWAGGER VARIABLES
	public static String SWAGGER_API_SPEC_VERSION = "1.2.3";
	static {
		loadDefaultValues();
	}

	private static void loadDefaultValues() {
		errorStatusCodes.put(200, "SUCCESS");
		errorStatusCodes.put(500, "ERROR");

	}
	
	  

	public static Response getResponse(int statusCode, Map<?,?> map) {

		return Response.status(statusCode).entity(map)
				.header("domainName", "party")
				.header("status", errorStatusCodes.get(statusCode)).build();
	}

	public static Response getResponse(int statusCode, Object entity) {
		return Response.status(statusCode).entity(entity)
				.header("domainName", "party")
				.header("status", errorStatusCodes.get(statusCode)).build();
	}
	
	public static void loadSwaggerConfiguration(ServletConfig config) {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion(Constants.SWAGGER_API_SPEC_VERSION);
		beanConfig.setSchemes(new String[] { Constants.SWAGGER_API_HTTP });
		beanConfig.setBasePath(config.getServletContext().getContextPath());
		beanConfig.setResourcePackage(Constants.SWAGGER_API_PACKAGE);
		beanConfig.setScan(true);
	}

}
