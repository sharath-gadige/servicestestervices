package com.bighalf.service.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bighalf.service.datasquare.util.Log4jLoder;
import com.bighalf.service.datasquare.util.PropertiesLoader;
import com.bighalf.spark.helpers.DatasquaresUtil;

/**
 * Servlet class used to load configurations (log4j, Cassandra, Swagger and
 * property files)
 * 
 * @author Mateen, Big Half. Jul 13, 2015
 * @version 1.0
 *
 */

public class ConfigurationLoaderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * this method is called while the server startup or on deploying of the
	 * application to the server
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		DatasquaresUtil.loadSwaggerConfiguration(config);
		Log4jLoder.getLog4jLoder().initilializeLogging();
		PropertiesLoader.getPropertiesLoader().loadProjectProperties();
		try{
//			Class.forName("com.bighalf.cassandra.common.CassandraConstants");
//			Class.forName("com.bighalf.spark.jdbc.ConnectionUtils");
			System.out.println("succesfully loaded com.bighalf.cassandra.common.CassandraConstants");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}