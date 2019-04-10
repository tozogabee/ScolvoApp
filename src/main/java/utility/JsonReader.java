package main.java.utility;

import main.java.pojos.Address;
import main.java.pojos.Client;

import java.util.List;

public interface JsonReader {
	
	Client getClientsId(String key);
	
	List<Address> getAddresses(String mainJsonElement);

}
