package test.jsonreadertest;

import main.java.pojos.Address;
import main.java.pojos.Client;
import main.java.utility.JsonReader;
import main.java.utility.impl.JsonReaderImpl;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.utilities.*;


import java.util.List;


public class JsonReaderTest {
	
	private static final Logger log = Logger.getLogger(JsonReaderTest.class);

	  private JsonReader clientJSON;
	  private JsonReader addressJSON;
	  private List<Address> addresses;
	  private Client client;
	  
		
	  @Test
	  public void isClientSizeTest() {
		  Assert.assertEquals(client.getAddressIds().size(),7);
		  log.info("isClientSizeNotNullTest PASSED");
	  }
	  
	  @Test
	  public void isAddressesSizeTest() {
		  Assert.assertEquals(addresses.size(),7);
		  log.info("isAddressesSizeTest PASSED");
	  }
	  
	  @Test
	  public void isClientCorrespondToAddressTest() {
		  int counter = comparingTheClientAndAddress(client, addresses);
		  Assert.assertEquals(counter,7);
		  log.info("isClientCorrespondToAddressTest PASSED");
	  }
	  
	  @Test
	  public void isCorrectAddressIds() {
		  Assert.assertEquals(client.getAddressIds().get(0), TestConstants.ADDRESS_ID_100);
		  Assert.assertEquals(client.getAddressIds().get(1), TestConstants.ADDRESS_ID_200);
		  Assert.assertEquals(client.getAddressIds().get(2), TestConstants.ADDRESS_ID_300);
		  Assert.assertEquals(client.getAddressIds().get(3), TestConstants.ADDRESS_ID_400);
		  Assert.assertEquals(client.getAddressIds().get(4), TestConstants.ADDRESS_ID_600);
		  Assert.assertEquals(client.getAddressIds().get(5), TestConstants.ADDRESS_ID_900);
		  Assert.assertEquals(client.getAddressIds().get(6), TestConstants.ADDRESS_ID_500);
		  log.info("isCorrectAddressIds PASSED");
	  }
	  
	  @Test
	  public void isCorrectPostalCodes() {
		  Assert.assertEquals(addresses.get(0).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_100);
		  Assert.assertEquals(addresses.get(1).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_300);
		  Assert.assertEquals(addresses.get(2).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_600);
		  Assert.assertEquals(addresses.get(3).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_900);
		  Assert.assertEquals(addresses.get(4).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_200);
		  Assert.assertEquals(addresses.get(5).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_400);
		  Assert.assertEquals(addresses.get(6).getPostalCode(), TestConstants.POSTAL_CODE_ADR_ID_500);
		  log.info("isCorrectPostalCodes PASSED");
	  }
	  
	  @Test
	  public void isCorrectCities() {
		  Assert.assertEquals(addresses.get(0).getCity(), TestConstants.CITY_BP);
		  Assert.assertEquals(addresses.get(1).getCity(), TestConstants.CITY_BP);
		  Assert.assertEquals(addresses.get(2).getCity(), TestConstants.CITY_BP);
		  Assert.assertEquals(addresses.get(3).getCity(), TestConstants.CITY_BP);
		  Assert.assertEquals(addresses.get(4).getCity(), TestConstants.CITY_BP);
		  Assert.assertEquals(addresses.get(5).getCity(), TestConstants.CITY_DEBR);
		  Assert.assertEquals(addresses.get(6).getCity(), TestConstants.CITY_NYH);
		  log.info("isCorrectCities PASSED");
	  }
	  
	  @Test
	  public void isCorrectAddress() {
		  Assert.assertEquals(addresses.get(0).getAddress(), TestConstants.ADDRESS_ADR_ID_100);
		  Assert.assertEquals(addresses.get(1).getAddress(), TestConstants.ADDRESS_ADR_ID_300);
		  Assert.assertEquals(addresses.get(2).getAddress(), TestConstants.ADDRESS_ADR_ID_600);
		  Assert.assertEquals(addresses.get(3).getAddress(), TestConstants.ADDRESS_ADR_ID_900);
		  Assert.assertEquals(addresses.get(4).getAddress(), TestConstants.ADDRESS_ADR_ID_200);
		  Assert.assertEquals(addresses.get(5).getAddress(), TestConstants.ADDRESS_ADR_ID_400);
		  Assert.assertEquals(addresses.get(6).getAddress(), TestConstants.ADDRESS_ADR_ID_500);
		  log.info("isCorrectAddress PASSED");
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		 clientJSON = new JsonReaderImpl("src/main/resources/client.txt");
		 addressJSON = new JsonReaderImpl("src/main/resources/address.txt");
		 client = clientJSON.getClientsId("addressIds");
		 addresses = addressJSON.getAddresses("addresses");
	  }

	  @AfterTest
	  public void afterTest() {
	  }
	  
	  private int comparingTheClientAndAddress(Client client, List<Address> addresses) {
		  List<Long> addressIds = client.getAddressIds();
		  int counter = 0;
		  for(Long actualId : addressIds) {
			  for(Address actualAddress : addresses) {
				  if(actualId.equals(actualAddress.getId())) {
					  ++counter;
				  }
			  }
		  }
		  return counter;
	  }

}
