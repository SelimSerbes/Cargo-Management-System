package homework1;

public class Packet {

	private int senderCustomer;
	private int receiverCustomer;
	private int weight;
	private String volume;
	private String date;
	private int id;
	private boolean delete;
	private int status;
	private int packet_fee;
	
	public Packet(int senderCustomer, int receiverCustomer, int weight, String volume, String date, int id,
			boolean delete,int status,int packet_fee) {
		this.senderCustomer = senderCustomer;
		this.receiverCustomer = receiverCustomer;
		this.weight = weight;
		this.volume = volume;
		this.date = date;
		this.id = id;
		this.delete = delete;
		this.status=status;
		this.packet_fee=packet_fee;
	}

	public int getSenderCustomer() {
		return senderCustomer;
	}

	public void setSenderCustomer(int senderCustomer) {
		this.senderCustomer = senderCustomer;
	}

	public int getReceiverCustomer() {
		return receiverCustomer;
	}

	public void setReceiverCustomer(int receiverCustomer) {
		this.receiverCustomer = receiverCustomer;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPacket_fee() {
		return packet_fee;
	}

	public void setPacket_fee(int packet_fee) {
		this.packet_fee = packet_fee;
	}
	
	
}
