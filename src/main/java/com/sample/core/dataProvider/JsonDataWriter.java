package com.sample.core.dataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import com.sample.core.manager.FileReaderManager;
import com.sample.google.testDataTypes.Account;
import com.sample.google.testDataTypes.Accounts;

public class JsonDataWriter {
	
	private final String accountFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "accounts.json";
	
	/**
	 * Method to update password for a provided brand and email in accountPassword file
	 * @param email - Email
	 * @param password - Password
	 * @return - true if update is completed, else false
	 */
	public boolean updateAccountPasswordData(String email, String password) {
		
		Gson gson = new Gson();
		//BufferedReader bufferedReader = null;
		FileWriter writer = null;
		Account[] accountData = null;
		String jsonString = null;
		boolean flag = false;
		
		try {
			//bufferedReader = new BufferedReader(new FileReader(accountFilePath));
			//accountData = gson.fromJson(bufferedReader, Account[].class);
			
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(accountFilePath));
			JsonObject jObject = (JsonObject)obj;
			JsonArray jArray = (JsonArray) jObject.get("accounts");
			accountData = gson.fromJson(jArray, Account[].class);
			try {
				for(Account ap : accountData) {
					if(ap.email.equalsIgnoreCase(email)) {
						ap.password = password;
						flag = true;
						break;
					}
				}
				if(flag) {
					jsonString = gson.toJson(accountData);
					jsonString = "{\"accounts\":" + jsonString +"}";
					writer = new FileWriter(accountFilePath);
					writer.write(jsonString);
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Account Password test data file not found at path:" + accountFilePath);
		} finally {
//			try {
//				if(bufferedReader != null) {
//					bufferedReader.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		
		return flag;
	}
	
	/**
	 * Method to add new record in accountPassword file
	 * @param email - Email
	 * @param password - Password
	 * @return - true if record is added, else false
	 */
	public boolean addAccountPasswordData(String email, String password) {
	
		Account acnPwd = new Account(email, password);
		Gson gson = new Gson();
		FileWriter writer = null;
		boolean flag = true;
		Account ap = null;
		try {
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(accountFilePath));
			JsonObject jObject = (JsonObject)obj;
			JsonArray jArray = (JsonArray) jObject.get("accounts");
			Iterator<JsonElement> iterator = jArray.iterator();
			Accounts acn = new Accounts();
			while(iterator.hasNext()) {
				ap = gson.fromJson(iterator.next().toString(),Account.class);
				acn.addAccount(ap);
				if(ap.email.equalsIgnoreCase(email)) {
					flag = false;
				}
			}
			if(flag) {
				try {
					writer = new FileWriter(accountFilePath);
					JsonWriter jw = new JsonWriter(writer);
					acn.addAccount(acnPwd);
					gson.toJson(acn,Accounts.class,jw);
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} catch (FileNotFoundException excp) {
			throw new RuntimeException("Account Password test data file not found at path:" + accountFilePath);
		}		
		return flag;
	}

}