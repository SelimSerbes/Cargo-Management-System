package homework1;

public class Office {

	private String name;
	private String address;
	private String town;
	private String city;
	private String phone;
	private int id;
	private boolean delete;
	private int totalincome;
	static class Employee {
		//inner class in here
		private int officeID;
		private String type;
		private String name_employee;
		private String birthdate_employee;
		private String gender_employee;
		private String address_employee;
		private String town_employee;
		private String city_employee;
		private String phone_employee;
		private int id_employee;
		private boolean delete_employee;
		private double salary;
		private int lostpacket; 
		
		public Employee(int officeID, String type, String name_employee, String birthdate_employee, String gender_employee, String address_employee,
				String town_employee, String city_employee, String phone_employee, int id_employee,boolean delete_employee,double salary,int lostpacket) {
			this.officeID = officeID;
			this.type = type;
			this.name_employee = name_employee;
			this.birthdate_employee = birthdate_employee;
			this.gender_employee = gender_employee;
			this.address_employee = address_employee;
			this.town_employee = town_employee;
			this.city_employee = city_employee;
			this.phone_employee = phone_employee;
			this.id_employee = id_employee;
			this.delete_employee=delete_employee;
			this.salary=salary;
			this.lostpacket=lostpacket;
		}

		public int getOfficeID() {
			return officeID;
		}

		public void setOfficeID(int officeID) {
			this.officeID = officeID;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName_employee() {
			return name_employee;
		}

		public void setName_employee(String name_employee) {
			this.name_employee = name_employee;
		}

		public String getBirthdate_employee() {
			return birthdate_employee;
		}

		public void setBirthdate_employee(String birthdate_employee) {
			this.birthdate_employee = birthdate_employee;
		}

		public String getGender_employee() {
			return gender_employee;
		}

		public void setGender_employee(String gender_employee) {
			this.gender_employee = gender_employee;
		}

		public String getAddress_employee() {
			return address_employee;
		}

		public void setAddress_employee(String address_employee) {
			this.address_employee = address_employee;
		}

		public String getTown_employee() {
			return town_employee;
		}

		public void setTown_employee(String town_employee) {
			this.town_employee = town_employee;
		}

		public String getCity_employee() {
			return city_employee;
		}

		public void setCity_employee(String city_employee) {
			this.city_employee = city_employee;
		}

		public String getPhone_employee() {
			return phone_employee;
		}

		public void setPhone_employee(String phone_employee) {
			this.phone_employee = phone_employee;
		}

		public int getId_employee() {
			return id_employee;
		}

		public void setId_employee(int id_employee) {
			this.id_employee = id_employee;
		}

		public boolean isDelete_employee() {
			return delete_employee;
		}

		public void setDelete_employee(boolean delete_employee) {
			this.delete_employee = delete_employee;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public int getLostpacket() {
			return lostpacket;
		}

		public void setLostpacket(int lostpacket) {
			this.lostpacket = lostpacket;
		}
		
		
		
	}
	public Office(String name, String address, String town, String city, String phone, int id,boolean delete,int totalincome) {
		this.name = name;
		this.address = address;
		this.town = town;
		this.city = city;
		this.phone = phone;
		this.id = id;
		this.delete=delete;
	}
	
	public Office(int id,String name,int totalincome) {
		this.id = id;
		this.name=name;
		this.totalincome=totalincome;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getTotalincome() {
		return totalincome;
	}
	public void setTotalincome(int totalincome) {
		this.totalincome = totalincome;
	}
	
	
	
}
