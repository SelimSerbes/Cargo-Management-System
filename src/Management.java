package homework1;

import java.io.*;

public class Management {

	// Employee.class is at Office.Class (inner Class)
	// Office.class have one more constructor.
	//I defined arrays here.
	private Office offices[] = new Office[999];
	private Office.Employee employees[] = new Office.Employee[999];
	private Customer customers[] = new Customer[999];
	private Packet packets[] = new Packet[999];
	private int office_of_count = 0;
	private int employee_of_count = 0;
	private int customer_of_count = 0;
	private int packet_of_count = 0;
	private static BufferedReader br;
	private int search_empty_count = 0;
	
	//Main function
	public void read_file() throws IOException {
		File file = new File("input.txt");
		br = new BufferedReader(new FileReader(file));
		String st;
		String spliting[];
		//I used infinite loop (while) for read processes
		while ((st = br.readLine()) != null) {

			spliting = st.split(";", -1);

			if (spliting[0].equalsIgnoreCase("addOffice")) {
				add_office(spliting[1], spliting[2], spliting[3], spliting[4], spliting[5]);
			} else if (spliting[0].equalsIgnoreCase("listOffices")) {
				display_office();
			} else if (spliting[0].equalsIgnoreCase("addEmployee")) {
				add_employee(Integer.parseInt(spliting[1]), spliting[2], spliting[3], spliting[4], spliting[5],
						spliting[6], spliting[7], spliting[8], spliting[9]);
			} else if (spliting[0].equalsIgnoreCase("listEmployees")) {
				display_employee();
			} else if (spliting[0].equalsIgnoreCase("addCustomer")) {
				add_customer(spliting[1], spliting[2], spliting[3], spliting[4], spliting[5], spliting[6], spliting[7],
						spliting[8]);
			} else if (spliting[0].equalsIgnoreCase("listCustomers")) {
				display_customer();
			} else if (spliting[0].equalsIgnoreCase("addPacket")) {
				add_packet(Integer.parseInt(spliting[1]), Integer.parseInt(spliting[2]), Integer.parseInt(spliting[3]),
						spliting[4], spliting[5]);
			} else if (spliting[0].equalsIgnoreCase("listPackets")) {
				display_packet();
			} else if (spliting[0].equalsIgnoreCase("updateOffice")) {
				update_office(Integer.valueOf(spliting[1]), spliting[2], spliting[3], spliting[4], spliting[5],
						spliting[6]);
			} else if (spliting[0].equalsIgnoreCase("updateEmployee")) {
				update_employee(Integer.valueOf(spliting[1]), Integer.valueOf(spliting[2]), spliting[3], spliting[4],
						spliting[5], spliting[6], spliting[7], spliting[8], spliting[9], spliting[10]);

			} else if (spliting[0].equalsIgnoreCase("updateCustomer")) {
				update_customer(Integer.valueOf(spliting[1]), spliting[2], spliting[3], spliting[4], spliting[5],
						spliting[6], spliting[7], spliting[8], spliting[9]);
			} else if (spliting[0].equalsIgnoreCase("updatePacket")) {
				update_packet(Integer.valueOf(spliting[1]), Integer.valueOf(spliting[2]), Integer.valueOf(spliting[3]),
						Integer.valueOf(spliting[4]), spliting[5], spliting[6]);
			} else if (spliting[0].equalsIgnoreCase("deleteOffice")) {
				delete_office(spliting[1]);
			} else if (spliting[0].equalsIgnoreCase("deleteEmployee")) {
				delete_employee(spliting[1]);
			} else if (spliting[0].equalsIgnoreCase("deleteCustomer")) {
				delete_customer(spliting[1]);
			} else if (spliting[0].equalsIgnoreCase("deletePacket")) {
				delete_packet(spliting[1]);
			} else if (spliting[0].equalsIgnoreCase("deliverPacket")) {
				int temp = 0;

				try {
					for (int i = 0; i < packets.length; i++) {
						if (packets[i].getId() == Integer.valueOf(spliting[1])) {
							packets[i].setStatus(1);
							temp = packets[i].getPacket_fee();
							break;
						}
					}
					int i = 0;
					while (employees[i] != null) {
						if (Integer.valueOf(spliting[2]) == employees[i].getId_employee()) {
							offices[employees[i].getOfficeID() - 1]
									.setTotalincome(offices[employees[i].getOfficeID() - 1].getTotalincome() + temp);
						}
						i++;
					}
				} catch (Exception e) {
					System.out.println(spliting[1] + "ID packet is not found!");
				}

			} else if (spliting[0].equalsIgnoreCase("lossPacket")) {
				try {
					for (int i = 0; i < packets.length; i++) {
						if (packets[i].getId() == Integer.valueOf(spliting[1])) {
							packets[i].setStatus(2);
							break;
						}
					}
					int j = 0;
					while (employees[j] != null) {
						if (Integer.valueOf(spliting[2]) == employees[j].getId_employee()) {
							employees[j].setLostpacket(employees[j].getLostpacket() + 1);
						} else if (employees[j].getLostpacket() == 3 && employees[j].isDelete_employee() == true) {
							employees[j].setDelete_employee(false);
							System.out.println("lost the number of packets reached 3.Therefore,"
									+ employees[j].getId_employee() + ".ID Employee was fired!");
							;
						}
						j++;
					}
				} catch (Exception e) {
					System.out.println(spliting[1] + "ID packet is not found!");
				}

			} else if (spliting[0].equalsIgnoreCase("trackPacket")) {
				try {
					for (int i = 0; i < customers.length; i++) {
						if (packets[i].getId() == Integer.valueOf(spliting[1])) {
							if (packets[i].getStatus() == 1) {
								System.out.println(spliting[1] + " ID packet is delivered!");
							}
							if (packets[i].getStatus() == 2) {
								System.out.println(spliting[1] + " ID packet lost!");
							}
							if (packets[i].getStatus() == 0) {
								System.out.println(spliting[1] + " ID packet is at delivering!");
							}
							break;
						}
					}
				} catch (Exception e) {
					System.out.println(spliting[1] + "ID packet is not found!");
				}
			} else if (spliting[0].equalsIgnoreCase("increaseSalaries")) {
				increase_salaries();
			} else if (spliting[0].equalsIgnoreCase("totalIncome")) {
				totalincome(Integer.valueOf(spliting[1]));
			} else if (spliting[0].equalsIgnoreCase("top3Customers")) {
				top3customer();
			} else if (spliting[0].equalsIgnoreCase("search")) {
				search_empty_count = 0;
				for (int i = 0; i < spliting.length; i++) {
					if (spliting[i].isEmpty()) {
						search_empty_count++;
					}
				}

				search(spliting[1], spliting[2], spliting[3], spliting[4], spliting[5]);
			}
		}

	}
	//I used the function for all processes.
	public void add_office(String name, String address, String town, String city, String phone) {
		String new_phone = "";
		if (phone.contains("+")) {
			Phone p = new Phone(phone.substring(1, 3), phone.substring(3, 6), phone.substring(6));
			new_phone = "+" + p.getCountrycode() + " (" + p.getCitycode() + ") " + p.getNumber();
		} else {
			Phone p = new Phone(phone.substring(0, 2), phone.substring(2, 5), phone.substring(5));
			new_phone = "+" + p.getCountrycode() + " (" + p.getCitycode() + ") " + p.getNumber();
		}

		Address new_address = new Address(address, town, city);
		offices[office_of_count] = new Office(name, new_address.getAddress(), new_address.getTown(),
				new_address.getCity(), new_phone, office_of_count + 1, true, 0);
		office_of_count++;
	}

	public void add_employee(int office_id, String type, String name, String birthdate, String gender, String address,
			String town, String city, String phone) {
		Date date_packet = new Date(Integer.valueOf(birthdate.substring(0, 2)),
				Integer.valueOf(birthdate.substring(3, 5)), Integer.valueOf(birthdate.substring(6)));
		String new_birthdate = date_packet.getDay() + "/" + date_packet.getMonth() + "/" + date_packet.getYear();
		boolean flag = false;
		if ((date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 1)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 28) && (date_packet.getMonth() == 2)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 3)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 4)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 5)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 6)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 7)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 8)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 9)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 10)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 11)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 12)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 29) && (date_packet.getMonth() == 2)
						&& (date_packet.getYear() % 4 == 0)) {
			flag = true;
		}
		String new_phone = "";
		if (phone.contains("+")) {
			Phone p = new Phone(phone.substring(1, 3), phone.substring(3, 6), phone.substring(6));
			new_phone = "+" + p.getCountrycode() + " (" + p.getCitycode() + ") " + p.getNumber();
		} else {
			Phone p = new Phone(phone.substring(0, 2), phone.substring(2, 5), phone.substring(5));
			new_phone = "+" + p.getCountrycode() + " (" + p.getCitycode() + ") " + p.getNumber();
		}
		Address new_address = new Address(address, town, city);
		if (flag == true) {
			employees[employee_of_count] = new Office.Employee(office_id, type, name, new_birthdate, gender,
					new_address.getAddress(), new_address.getTown(), new_address.getCity(), new_phone,
					employee_of_count + 1, true, 2020.58, 0);
			employee_of_count++;
		} else {
			System.out.println("(Invalid Date) Date is wrong.The adding operation was canceled.");
		}
	}

	public void add_customer(String name, String birthdate, String gender, String e_mail, String address, String town,
			String city, String phone) {
		Date date_packet = new Date(Integer.valueOf(birthdate.substring(0, 2)),
				Integer.valueOf(birthdate.substring(3, 5)), Integer.valueOf(birthdate.substring(6)));
		String new_birthdate = date_packet.getDay() + "/" + date_packet.getMonth() + "/" + date_packet.getYear();
		boolean flag = false;
		if ((date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 1)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 28) && (date_packet.getMonth() == 2)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 3)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 4)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 5)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 6)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 7)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 8)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 9)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 10)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 11)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 12)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 29) && (date_packet.getMonth() == 2)
						&& (date_packet.getYear() % 4 == 0)) {
			flag = true;
		}
		String new_phone = "";
		if (phone.contains("+")) {
			Phone p = new Phone(phone.substring(1, 3), phone.substring(3, 6), phone.substring(6));
			new_phone = "+" + p.getCountrycode() + " (" + p.getCitycode() + ") " + p.getNumber();
		} else {
			Phone p = new Phone(phone.substring(0, 2), phone.substring(2, 5), phone.substring(5));
			new_phone = "+" + p.getCountrycode() + " (" + p.getCitycode() + ") " + p.getNumber();
		}
		Address new_address = new Address(address, town, city);
		if (flag == true) {
			customers[customer_of_count] = new Customer(name, new_birthdate, gender, e_mail, new_address.getAddress(),
					new_address.getTown(), new_address.getCity(), new_phone, customer_of_count + 1, true, 0);
			customer_of_count++;
		} else {
			System.out.println("(Invalid Date) Date is wrong.The adding operation was canceled.");
		}
	}

	public void add_packet(int sendercustomer, int receivercustomer, int weight, String volume, String date) {
		Date date_packet = new Date(Integer.valueOf(date.substring(0, 2)), Integer.valueOf(date.substring(3, 5)),
				Integer.valueOf(date.substring(6)));
		String new_date = date_packet.getDay() + "/" + date_packet.getMonth() + "/" + date_packet.getYear();
		boolean flag = false;
		if ((date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 1)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 28) && (date_packet.getMonth() == 2)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 3)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 4)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 5)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 6)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 7)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 8)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 9)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 10)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 30) && (date_packet.getMonth() == 11)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 31) && (date_packet.getMonth() == 12)
				|| (date_packet.getDay() >= 1 && date_packet.getDay() <= 29) && (date_packet.getMonth() == 2)
						&& (date_packet.getYear() % 4 == 0)) {
			flag = true;
		}
		if (flag == true) {
			if (customers[sendercustomer - 1] != null) {
				int packet_fee = 0;
				if ((weight >= 1 && weight <= 5) && volume.equalsIgnoreCase("small"))
					packet_fee = 10;
				else if ((weight >= 1 && weight <= 5) && volume.equalsIgnoreCase("medium"))
					packet_fee = 15;
				else if ((weight >= 1 && weight <= 5) && volume.equalsIgnoreCase("large"))
					packet_fee = 20;
				else if ((weight >= 6 && weight <= 10) && volume.equalsIgnoreCase("small"))
					packet_fee = 25;
				else if ((weight >= 6 && weight <= 10) && volume.equalsIgnoreCase("medium"))
					packet_fee = 30;
				else if ((weight >= 6 && weight <= 10) && volume.equalsIgnoreCase("large"))
					packet_fee = 40;
				else if ((weight >= 11) && volume.equalsIgnoreCase("small"))
					packet_fee = 45;
				else if ((weight >= 11) && volume.equalsIgnoreCase("medium"))
					packet_fee = 50;
				else if ((weight >= 11) && volume.equalsIgnoreCase("large"))
					packet_fee = 55;
				/*
				 * else { System.out.println("Your volume is wrong!");
				 * customers[sendercustomer]=null; }
				 */
				int i = 0;
				while (customers[i] != null) {
					if (sendercustomer == customers[i].getId()) {
						customers[i].setSentpacket(customers[i].getSentpacket() + 1);
					}
					i++;
				}
				packets[packet_of_count] = new Packet(sendercustomer, receivercustomer, weight, volume, new_date,
						packet_of_count + 1, true, 0, packet_fee);
				packet_of_count++;
			} else {
				System.out.println(sendercustomer + ".(Customer) Non-existing ID (Add packet process)");
			}
		} else {
			System.out.println("(Invalid Date) Date is wrong.The adding operation was canceled.");
		}
	}

	public void update_office(int id, String name, String Address, String town, String city, String phone) {
		if (offices[id - 1] != null) {
			offices[id - 1].setName(name);
			offices[id - 1].setAddress(Address);
			offices[id - 1].setTown(town);
			offices[id - 1].setCity(city);
			offices[id - 1].setPhone(phone);
		} else {
			System.out.println(id + ".(Office) Non-existing ID (Update process)");
		}
	}

	public void update_employee(int employee_id, int office_id, String type, String name, String birthdate,
			String gender, String Address, String town, String city, String phone) {
		if (employees[employee_id - 1] != null) {
			employees[employee_id - 1].setOfficeID(office_id);
			employees[employee_id - 1].setType(type);
			employees[employee_id - 1].setName_employee(name);
			employees[employee_id - 1].setBirthdate_employee(birthdate);
			employees[employee_id - 1].setGender_employee(gender);
			employees[employee_id - 1].setAddress_employee(Address);
			employees[employee_id - 1].setTown_employee(town);
			employees[employee_id - 1].setCity_employee(city);
			employees[employee_id - 1].setPhone_employee(phone);
		} else {
			System.out.println(employee_id + ".(Employee) Non-existing ID (Update process)");
		}
	}

	public void update_customer(int id, String name, String birthdate, String gender, String e_mail, String Address,
			String town, String city, String phone) {
		if (customers[id - 1] != null) {
			customers[id - 1].setName(name);
			customers[id - 1].setBirthdate(birthdate);
			customers[id - 1].setGender(gender);
			customers[id - 1].setE_mail(e_mail);
			customers[id - 1].setAddress(Address);
			customers[id - 1].setTown(town);
			customers[id - 1].setCity(city);
			customers[id - 1].setPhone(phone);
		} else {
			System.out.println(id + ".(Customer) Non-existing ID (Update process)");
		}
	}

	public void update_packet(int id, int sendercustomer, int receivercustomer, int weight, String volume,
			String date) {
		;
		if (packets[id - 1] != null) {
			packets[id - 1].setSenderCustomer(sendercustomer);
			packets[id - 1].setReceiverCustomer(receivercustomer);
			packets[id - 1].setWeight(weight);
			packets[id - 1].setVolume(volume);
			packets[id - 1].setDate(date);
		} else {
			System.out.println(id + ".(Packet) Non-existing ID (Update process)");
		}
	}

	public void delete_office(String delete) {
		try {
			for (int i = 0; i < offices.length; i++) {
				if (offices[i].getId() == Integer.valueOf(delete)) {
					offices[i].setDelete(false);
					System.out.println(delete + ".Office is deleted!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(delete + ".Office was not deleted(Deleting a non-existing ID)!");
		}
	}

	public void delete_employee(String delete) {
		try {
			for (int i = 0; i < employees.length; i++) {
				if (employees[i].getId_employee() == Integer.valueOf(delete)) {
					employees[i].setDelete_employee(false);
					System.out.println(delete + ".Employee is deleted!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(delete + ".Employee was not deleted(Deleting a non-existing ID)!");
		}
	}

	public void delete_customer(String delete) {
		try {
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].getId() == Integer.valueOf(delete)) {
					customers[i].setDelete(false);
					System.out.println(delete + ".Customer is deleted!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(delete + ".Customer was not deleted(Deleting a non-existing ID)!");
		}
	}

	public void delete_packet(String delete) {
		try {
			for (int i = 0; i < packets.length; i++) {
				if (packets[i].getId() == Integer.valueOf(delete)) {
					packets[i].setDelete(false);
					System.out.println(delete + ".Packet is deleted!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(delete + ".Packet was not deleted(Deleting a non-existing ID)!");
		}
	}

	public void display_office() {
		try {
			for (int i = 0; i < offices.length; i++) {
				if (offices[i].isDelete() == true) {
					System.out.println("~ Office Display ~");
					System.out.println("Id : " + offices[i].getId());
					System.out.println("Name : " + offices[i].getName());
					System.out.println("Adress : " + offices[i].getAddress());
					System.out.println("Town : " + offices[i].getTown());
					System.out.println("City : " + offices[i].getCity());
					System.out.println("Phone : " + offices[i].getPhone());
					System.out.println();
				}
			}
		} catch (Exception e) {

		}
	}

	public void display_employee() {
		try {
			for (int i = 0; i < employees.length; i++) {
				if (employees[i].isDelete_employee() == true) {
					System.out.println("~ Employee Display ~");
					System.out.println("Id : " + employees[i].getId_employee());
					System.out.println("OfficeID : " + employees[i].getOfficeID());
					System.out.println("Type : " + employees[i].getType());
					System.out.println("Name : " + employees[i].getName_employee());
					System.out.println("Birthdate : " + employees[i].getBirthdate_employee());
					System.out.println("Gender : " + employees[i].getGender_employee());
					System.out.println("Address : " + employees[i].getAddress_employee());
					System.out.println("Town : " + employees[i].getTown_employee());
					System.out.println("City : " + employees[i].getCity_employee());
					System.out.println("Phone : " + employees[i].getPhone_employee());
					System.out.println("Salary : " + employees[i].getSalary());
					System.out.println();
				}
			}
		} catch (Exception e) {

		}
	}

	public void display_customer() {
		try {
			for (int i = 0; i < customers.length; i++) {
				if (customers[i].isDelete() == true) {
					System.out.println("~ Customer Display ~");
					System.out.println("Id : " + customers[i].getId());
					System.out.println("Name : " + customers[i].getName());
					System.out.println("Birthdate : " + customers[i].getBirthdate());
					System.out.println("Gender : " + customers[i].getGender());
					System.out.println("E-mail : " + customers[i].getE_mail());
					System.out.println("Address : " + customers[i].getAddress());
					System.out.println("Town : " + customers[i].getTown());
					System.out.println("City : " + customers[i].getCity());
					System.out.println("Phone : " + customers[i].getPhone());
					System.out.println();
				}
			}
		} catch (Exception e) {

		}
	}

	public void display_packet() {
		try {
			for (int i = 0; i < packets.length; i++) {
				if (packets[i].isDelete() == true) {
					System.out.println("~ Packet Display ~");
					System.out.println("Id : " + packets[i].getId());
					System.out.println("Sender Customer : " + packets[i].getSenderCustomer());
					System.out.println("Receiver Customer : " + packets[i].getReceiverCustomer());
					System.out.println("Weight : " + packets[i].getWeight());
					System.out.println("Volume : " + packets[i].getVolume());
					System.out.println("Date : " + packets[i].getDate());
					System.out.println("Status : " + packets[i].getStatus());
					System.out.println("Fee : " + packets[i].getPacket_fee());
					System.out.println();
				}
			}
		} catch (Exception e) {

		}
	}

	public void increase_salaries() {
		int k = 0;
		while (employees[k] != null) {
			employees[k].setSalary(employees[k].getSalary() + employees[k].getSalary() * 0.10);
			k++;
		}
	}

	public void totalincome(int office_id) {
		int i = 0;
		while (offices[i] != null) {
			if (office_id == offices[i].getId()) {
				System.out.println(offices[i].getName() + " Total income : " + offices[i].getTotalincome() + " TL");
			}
			i++;
		}
	}

	public void top3customer() {
		int count = 0;
		int k = 0;
		int temp;
		String temp2;
		while (customers[k] != null) {
			count++;
			k++;
		}
		String array[] = new String[count];
		int array2[] = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = customers[i].getName();
			array2[i] = customers[i].getSentpacket();
		}
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array2[j] < array2[i]) {
					temp = array2[i];
					temp2 = array[i];
					array2[i] = array2[j];
					array[i] = array[j];
					array2[j] = temp;
					array[j] = temp2;
				}
			}

		}
		System.out.println("- Top 3 Customer -");
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + ".)" + array[i] + " - SentPacket : " + array2[i]);
		}

	}

	public void search(String fromcity, String tocity, String status, String min_max, String volume) {
		System.out.println("~ Packet Search ~");
		int i = 0;
		int k = 0;
		int j = 0;
		int min = 0;
		int max = 0;
		String temp1 = "";
		String temp2 = "";
		String array[];
		try {
			array = min_max.split("-");
			min = Integer.valueOf(array[0]);
			max = Integer.valueOf(array[1]);
		} catch (Exception e) {
		}
		try {
			while (packets[i] != null) {

				while (customers[j] != null) {
					if (packets[i].getSenderCustomer() == customers[j].getId()) {
						temp1 = customers[j].getCity();
					}
					j++;
				}

				while (customers[k] != null) {
					if (packets[i].getReceiverCustomer() == customers[k].getId()) {
						temp2 = customers[k].getCity();
					}
					k++;
				}

				if ((temp1.equalsIgnoreCase(fromcity) || (fromcity.isEmpty()))
						&& (temp2.equalsIgnoreCase(tocity) || (tocity.isEmpty()))
						&& (packets[i].getStatus() == Integer.valueOf(status) || (status.isEmpty()))
						&& ((packets[i].getWeight() >= min && packets[i].getWeight() <= max) || (min_max.isEmpty()))
						&& (packets[i].getVolume().equalsIgnoreCase(volume) || (volume.isEmpty()))) {

					System.out.println("Id : " + packets[i].getId());
					System.out.println("Sender Customer : " + packets[i].getSenderCustomer());
					System.out.println("Receiver Customer : " + packets[i].getReceiverCustomer());
					System.out.println("Weight : " + packets[i].getWeight());
					System.out.println("Volume : " + packets[i].getVolume());
					System.out.println("Date : " + packets[i].getDate());
					System.out.println("Status : " + packets[i].getStatus());
					System.out.println("Fee : " + packets[i].getPacket_fee());
					System.out.println();

				}

				i++;
			}
		} catch (Exception e) {

		}
		int t=0;
		if (search_empty_count == 5) {
			while(packets[t]!=null) {
			System.out.println("Id : " + packets[t].getId());
			System.out.println("Sender Customer : " + packets[t].getSenderCustomer());
			System.out.println("Receiver Customer : " + packets[t].getReceiverCustomer());
			System.out.println("Weight : " + packets[t].getWeight());
			System.out.println("Volume : " + packets[t].getVolume());
			System.out.println("Date : " + packets[t].getDate());
			System.out.println("Status : " + packets[t].getStatus());
			System.out.println("Fee : " + packets[t].getPacket_fee());
			System.out.println();
			t++;
			}
		}
	}
}
