package main.java.pojos;

public class Address {
	
	private Long id;
	private Long postalCode;
	private String city;
	private String address;
	
	public Address(Long id, Long postalCode, String city, String address) {
		super();
		this.id = id;
		this.postalCode = postalCode;
		this.city = city;
		this.address = address;
	}
	public Address() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", postalCode=" + postalCode + ", city=" + city + ", address=" + address + "]";
	}
	
	
	
}
