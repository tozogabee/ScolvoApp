package main.java.utility.impl;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import main.java.pojos.Address;
import main.java.pojos.Client;
import main.java.utility.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderImpl implements JsonReader {

	private JSONObject jsonObject;
	
	
	private static Logger log = Logger.getLogger(JsonReaderImpl.class);
	
	public JsonReaderImpl() {	
	}
	
	public JsonReaderImpl(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	
	
	public JsonReaderImpl(String fileName) {
		JSONParser parser = new JSONParser();
		try {
			jsonObject =(JSONObject) parser.parse(input(fileName));
			log.info("the file exists - "+fileName);
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException - "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException - "+e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			log.error("ParseException - "+e.getMessage());
			e.printStackTrace();
		}
	}	
	
	@Override
	public Client getClientsId(String key) {
		List<Long> addressIds = new ArrayList<>();
		JSONArray clientsArray = getElementsByKey(key);
		for(int i = 0; i < clientsArray.size();  ++i) {
			addressIds.add(Long.parseLong(clientsArray.get(i).toString()));
		}
		Client client = new Client(addressIds);
		return client;
	}

	@Override
	public List<Address> getAddresses(String mainJsonElement) {
		List<Address> allAddresses = new ArrayList<>();
		JSONArray jsonAddresses = getElementsByKey(mainJsonElement);
		for(int i = 0; i < jsonAddresses.size(); ++i) {
		    JSONObject act = (JSONObject)jsonAddresses.get(i);
		    Long id = Long.parseLong(act.get("id").toString());
		    log.debug("id - "+id);
		    Long postalCode = Long.parseLong(act.get("PostalCode").toString());
		    log.debug("postal code - "+postalCode);
		    String city = act.get("City").toString();
		    log.debug("city - "+city);
		    String address = act.get("Address").toString();
		    log.debug("address - "+address);
		    Address actual = new Address(id,postalCode,city,address);
		    allAddresses.add(actual);
		    log.debug("actual address - "+act);
		}
		return allAddresses;
	}
	
	private static FileReader input(String fileName) throws FileNotFoundException {
		FileReader fr = new FileReader(fileName);
		return fr;
	}
	
	

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		jsonObject = jsonObject;
	}
	
	private JSONArray getElementsByKey(String key) {
		return (JSONArray)this.getJsonObject().get(key);	
	}

	
	
	
	
	
	
	
	
	

}
