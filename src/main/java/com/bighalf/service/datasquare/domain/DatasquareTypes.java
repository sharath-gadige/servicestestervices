package com.bighalf.service.datasquare.domain;

import java.util.Arrays;
import java.util.List;

public class DatasquareTypes {
	
	
	private DatasquareTypes(){}
	
	static String[] arr = {
			"EXCEL",
			"SALES FORCE",
			"QUICK BOOOK",
			"ZEN DESK",
			"ZEN PAYROLL",
			"JIRA",
			"FIT BIT",
			"SURVEY MONKEY",
			"DAILY MOTION",
			"SAGE",
			"GOOGLE DRIVE",
			"DROP BOX",
			"SALES FORCE"
			};
	private static List<String> datasquareList=Arrays.asList(arr);

	public static List<String> getDataSquareList(){
		return datasquareList;
	}
	
	@Override
	public Object clone(){
		return null;
	}
}
