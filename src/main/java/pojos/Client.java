package main.java.pojos;

import java.util.List;

public class Client {
	
	private List<Long> addressIds;

	public Client(List<Long> addressIds) {
		super();
		this.addressIds = addressIds;
	}

	public List<Long> getAddressIds() {
		return addressIds;
	}

	public void setAddressIds(List<Long> addressIds) {
		this.addressIds = addressIds;
	}

	@Override
	public String toString() {
		return "Client [addressIds=" + addressIds + "]";
	}
	
	
	
	
}
