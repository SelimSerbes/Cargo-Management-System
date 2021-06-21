package homework1;

public class Phone {
	
	private String countrycode;
	private String citycode;
	private String number;
	
	public Phone(String countrycode, String citycode, String number) {
		this.countrycode = countrycode;
		this.citycode = citycode;
		this.number = number;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
