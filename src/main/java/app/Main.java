package main.java.app;

import main.java.pojos.*;
import main.java.utility.*;
import main.java.utility.impl.JsonReaderImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);
	
		public static void main(String[] args) {
			JsonReader clientJSON = new JsonReaderImpl("src/main/resources/client.txt");
			JsonReader addressJSON = new JsonReaderImpl("src/main/resources/address.txt");
			List<Long> addressIds = addressIds(clientJSON);
			List<Address> allAddresses = allAddresses(addressJSON);
			log.info("-------------------------Main---------------------------");
			listingTheAddresses(addressIds, allAddresses);
	}
		
	private static List<Long> addressIds(JsonReader clientJSON) {
		Client clients = clientJSON.getClientsId("addressIds");
		List<Long> addressIds = clients.getAddressIds();
		return addressIds;
	}
	
	private static List<Address> allAddresses(JsonReader addressJSON) {
		List<Address> allAddresses = addressJSON.getAddresses("addresses");
		return allAddresses;
	}
		
	private static boolean isAddressAvailable(Long addressId, Address address) {
		if(address.getId().equals(addressId)) {
			return true;
		}
		return false;
	}
	
	private static void listingTheAddresses(List<Long> addressIds, List<Address> addresses) {
		for(Long act : addressIds) {
			for(Address actualAddress : addresses) {
				if(isAddressAvailable(act, actualAddress)) {
					if(actualAddress.getAddress()!=null) {
						log.info(actualAddress.getPostalCode()+" "+actualAddress.getCity()+" "+actualAddress.getAddress());
					}
					else {
						log.info(actualAddress.getPostalCode()+" "+actualAddress.getCity());
					}
				}
			}
		}
	}
	
	
	
	
	
	
}
