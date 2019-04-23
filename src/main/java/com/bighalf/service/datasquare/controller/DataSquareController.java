package com.bighalf.service.datasquare.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.bighalf.service.datasquare.domain.DataSquare;
import com.bighalf.service.datasquare.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Uday Koorella
 *
 *         Jun 16, 2015
 */
@Api(value = "DataSquare Services", description = "Used to perform curd opertions on datasquares and endpoints like getdataSquareList, getAttributes, getPreview, getAttributeValue, getdatasquaresTypes, getDataSquaresByType, createDataSquareId")
@Path("user/{userId}/datasquares")
public class DataSquareController {

	/**
	 * this method is used to create a datasquare
	 * 
	 * @param jsonString
	 * @param userId
	 * @return empty
	 */
	@POST
	@ApiOperation(value = "Returns created dataSquaredID ", notes = "create datasquare requires raw json, below is an example of raw json"
			+ " <span class='bolder'>Sample: Request :</span>"
			+ "<div class='sample_resquest'>"
			+ "{  \"datasquare_id\": \"d1\",  \"dataSquare_Name\": \"test\",  \"dataSquare_Type\": \"test\",  \"description\": \"desc\",  \"refresh_rate\": \"Daily\",  \"startDateTime\":\"20150904 12:19:00.000\",  \"endDateTime\":\"20150904 01:19:00.000\"}"
			+ "</div>", responseContainer = "java.lang.String")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataSquare createDataSquare(@PathParam("userId") String user_id,
			DataSquare dataSquare) {
		dataSquare.setDatasquareId(Constants.database.size()+""); 
		Constants.database.add(dataSquare);
		return dataSquare;
	}
	
	
	
	@GET
	@ApiOperation(value = "Returns created dataSquaredID ", notes = "create datasquare requires raw json, below is an example of raw json"
			+ " <span class='bolder'>Sample: Request :</span>"
			+ "<div class='sample_resquest'>"
			+ "{  \"datasquare_id\": \"d1\",  \"dataSquare_Name\": \"test\",  \"dataSquare_Type\": \"test\",  \"description\": \"desc\",  \"refresh_rate\": \"Daily\",  \"startDateTime\":\"20150904 12:19:00.000\",  \"endDateTime\":\"20150904 01:19:00.000\"}"
			+ "</div>", responseContainer = "java.lang.String")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<DataSquare> getAllDataSquare(@PathParam("userId") String user_id,@PathParam("datasquareID") int datasquareID ) {
		return Constants.database;
	}
	
	
	@GET
	@Path("{datasquareID}")
	@ApiOperation(value = "Returns created dataSquaredID ", notes = "create datasquare requires raw json, below is an example of raw json"
			+ " <span class='bolder'>Sample: Request :</span>"
			+ "<div class='sample_resquest'>"
			+ "{  \"datasquare_id\": \"d1\",  \"dataSquare_Name\": \"test\",  \"dataSquare_Type\": \"test\",  \"description\": \"desc\",  \"refresh_rate\": \"Daily\",  \"startDateTime\":\"20150904 12:19:00.000\",  \"endDateTime\":\"20150904 01:19:00.000\"}"
			+ "</div>", responseContainer = "java.lang.String")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DataSquare createDataSquare(@PathParam("userId") String user_id,@PathParam("datasquareID") int datasquareID ) {
		if(datasquareID > Constants.database.size()) {
		throw new WebApplicationException("Invalid DatasquareID/Overlimit of Database", 500);	
		}
		DataSquare dataSquare = Constants.database.get(datasquareID);
		return dataSquare;
	}
 
}
