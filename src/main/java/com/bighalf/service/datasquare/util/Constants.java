package com.bighalf.service.datasquare.util;

import java.util.ArrayList;
import java.util.List;

import com.bighalf.service.datasquare.domain.DataSquare;

public class Constants {

	public static final Integer SUCCESS_RESPONSE_CODE = 200;
	public static final Integer ERROR_RESPONSE_CODE = 200;
	public static final Integer EMPTY_RESPONSE_CODE = 200;
	public static final Integer INVALID_INPUT_RESPONSE_CODE = 200;
	public static final Integer DS_NAME_EXISTS_RESPONSE_CODE = 412;
	public static final String INVALID_INPUT_RESPONSE_STRING = "Invalid input provided";
	public static final String EMPTY_RESPONSE_STRING = "Requested data not found";
	public static final String GENERIC_EMPTY_RESPONSE_STR = "Improper input received";
	public static final String GENERIC_ERROR_RESPONSE_STR = "Error! while performing the requested operation";
	public static final String DATASQUARE_NAME_EXISTS_RESPONSE_STR = "Datasquare Name already exists";
	public static final String SWAGGER_API_SPEC_VERSION="";
	public static final String SWAGGER_API_HTTP="http";
	public static final String SWAGGER_API_PACKAGE="com.bighalf.service.datasquare.controller";
	public static final String DATASQUARE_TYPE="dataSquare_Type";
	public static final String JIRA_DATASQUARE_TYPE="jira";
	public static final String SPRINT_PREPEND_KEY="sprint";
	public static final String JIRA_RAWDATA_TABLE="jira_rawdata";
	public static final String JIRA_SPRINT_TABLE="jira_sprint";
	public static String PROJECT_CURRENT_VERSION= "project.current.version";
	public static final String EMPTY_STRING = "";
	
	public static List<DataSquare> database = new ArrayList<>();
	
}
