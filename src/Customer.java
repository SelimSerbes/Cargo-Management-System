package homework1;

public class Customer {

	private String name;
	private String birthdate;
	private String gender;
	private String e_mail;
	private String address;
	private String town;
	private String city;
	private String phone;
	private int id;
	private boolean delete;
	private int sentpacket;
	
	public Customer(String name, String birthdate, String gender, String e_mail, String address, String town,
			String city, String phone, int id,boolean delete,int sentpacket) {
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.e_mail = e_mail;
		this.address = address;
		this.town = town;
		this.city = city;
		this.phone = phone;
		this.id = id;
		this.delete=delete;
		this.sentpacket=sentpacket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public int getSentpacket() {
		return sentpacket;
	}

	public void setSentpacket(int sentpacket) {
		this.sentpacket = sentpacket;
	}
	
	
}
