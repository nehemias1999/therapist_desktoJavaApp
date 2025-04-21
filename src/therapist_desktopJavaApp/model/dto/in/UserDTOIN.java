package therapist_desktopJavaApp.model.dto.in;

public class UserDTOIN {
	private String userDTODNI;
	private String userDTOName;
	private String userDTOLastName;
	private String userDTOBirthDate;
	private String userDTOEmail;
	private String userDTOAddress;
	private String userDTOAddressNumber;
	private String userDTOAddressFloor;
	private String userDTOAddressApartment;
	private String countryId;
	private String provinceId;
	private String cityId;
	
	public UserDTOIN(
			String userDTODNI, 
			String userDTOName, 
			String userDTOLastName, 
			String userDTOBirthDate, 
			String userDTOEmail,
			String userDTOAddress, 
			String userDTOAddressNumber, 
			String userDTOAddressFloor, 
			String userDTOAddressApartment,
			String countryId, 
			String provinceId, 
			String cityId) {
		this.userDTODNI = userDTODNI;
		this.userDTOName = userDTOName;
		this.userDTOLastName = userDTOLastName;
		this.userDTOBirthDate = userDTOBirthDate;
		this.userDTOEmail = userDTOEmail;
		this.userDTOAddress = userDTOAddress;
		this.userDTOAddressNumber = userDTOAddressNumber;
		this.userDTOAddressFloor = userDTOAddressFloor;
		this.userDTOAddressApartment = userDTOAddressApartment;
		this.countryId = countryId;
		this.provinceId = provinceId;
		this.cityId = cityId;
	}
	
	public String getUserDTODNI() {
		return userDTODNI;
	}
	
	public void setUserDTODNI(String userDTODNI) {
		this.userDTODNI = userDTODNI;
	}
	
	public String getUserDTOName() {
		return userDTOName;
	}
	
	public void setUserDTOName(String userDTOName) {
		this.userDTOName = userDTOName;
	}
	
	public String getUserDTOLastName() {
		return userDTOLastName;
	}
	
	public void setUserDTOLastName(String userDTOLastName) {
		this.userDTOLastName = userDTOLastName;
	}
	
	public String getUserDTOBirthDate() {
		return userDTOBirthDate;
	}
	
	public void setUserDTOBirthDate(String userDTOBirthDate) {
		this.userDTOBirthDate = userDTOBirthDate;
	}
	
	public String getUserDTOEmail() {
		return userDTOEmail;
	}
	
	public void setUserDTOEmail(String userDTOEmail) {
		this.userDTOEmail = userDTOEmail;
	}
	
	public String getUserDTOAddress() {
		return userDTOAddress;
	}
	
	public void setUserDTOAddress(String userDTOAddress) {
		this.userDTOAddress = userDTOAddress;
	}
	
	public String getUserDTOAddressNumber() {
		return userDTOAddressNumber;
	}
	
	public void setUserDTOAddressNumber(String userDTOAddressNumber) {
		this.userDTOAddressNumber = userDTOAddressNumber;
	}
	
	public String getUserDTOAddressFloor() {
		return userDTOAddressFloor;
	}
	
	public void setUserDTOAddressFloor(String userDTOAddressFloor) {
		this.userDTOAddressFloor = userDTOAddressFloor;
	}
	
	public String getUserDTOAddressApartment() {
		return userDTOAddressApartment;
	}
	
	public void setUserDTOAddressApartment(String userDTOAddressApartment) {
		this.userDTOAddressApartment = userDTOAddressApartment;
	}
	
	public String getCountryId() {
		return countryId;
	}
	
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	public String getProvinceId() {
		return provinceId;
	}
	
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
