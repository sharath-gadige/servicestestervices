package com.bighalf.service.datasquare.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Tao Zhong
 *
 *         Jun 16, 2015
 */
public class DataSquare {
	
	private String dataSquareID;
	private String dataSquareName;
	private String dataSquareType;
	private String lastTimeUpdate;
	private int numberOfCards;
	private ArrayList<Integer> cards;
	private String description;
	private String frequency;
	private LinkedHashMap<Integer, HashMap<String, String>> Data;
	private long timeToConnect;
	private String accessToken;
	private int numberOfRows;

	public String getDatasquareId() {
		return dataSquareID;
	}

	public void setDatasquareId(String datasquareId) {
		this.dataSquareID = datasquareId;
	}

	public String getDataSquareName() {
		return dataSquareName;
	}

	public void setDataSquareName(String dataSquareName) {
		this.dataSquareName = dataSquareName;
	}

	public String getDataSquareType() {
		return dataSquareType;
	}

	public void setDataSquareType(String dataSquareType) {
		this.dataSquareType = dataSquareType;
	}

	public String getLastTimeUpdate() {
		return lastTimeUpdate;
	}

	public void setLastTimeUpdate(String lastTimeUpdate) {
		this.lastTimeUpdate = lastTimeUpdate;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	public ArrayList<Integer> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Integer> cards) {
		this.cards = cards;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public LinkedHashMap<Integer, HashMap<String, String>> getData() {
		return Data;
	}

	public void setData(LinkedHashMap<Integer, HashMap<String, String>> data) {
		Data = data;
	}

	public long getTimeToConnect() {
		return timeToConnect;
	}

	public void setTimeToConnect(long timeToConnect) {
		this.timeToConnect = timeToConnect;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
}