package com.bighalf.service.datasquare.controller;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Mateen
 *
 *         Oct 23, 2015
 */
@Api(value = "Github Services", description = "get git call back data")
@Path("/git")
public class GithubController {

	public static HashMap<String, String> tempTestDataBase = new HashMap<String,String>();
	
	@POST 
	@ApiOperation(value = "No Return", notes = "used to Save the data from the git callback", responseContainer = "java.lang.String")
	@Consumes(MediaType.APPLICATION_JSON) 
	public void saveWebhooksData(String json) {
		tempTestDataBase.put("temp",json);
	}

	@GET 
	@ApiOperation(value = "JSON", notes = "used to get temp data from the git callback", responseContainer = "java.lang.String")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getWebhooksData(String json) {
//		return DatasquaresUtil.getResponse(200, tempTestDataBase.get("temp"));
		return null;
	}
}
