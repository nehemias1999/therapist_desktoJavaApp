package therapist_desktopJavaApp.model.dto.out;

import java.time.LocalDate;
import java.util.UUID;

public class UserDTOOUT {
	private UUID userId;
	private String userDTODNI;
	private String userDTOName;
	private String userDTOLastName;
	private LocalDate userDTOBirthDate;
	private String userDTOEmail;
	private String userDTOAddress;
	private int userDTOAddressNumber;
	private int userDTOAddressFloor;
	private String userDTOAddressApartment;
	private UUID countryId;
	private UUID provinceId;
	private UUID cityId;
	
	public UserDTOOUT(
			UUID userId, 
			String userDTODNI, 
			String userDTOName, 
			String userDTOLastName,
			LocalDate userDTOBirthDate, 
			String userDTOEmail, 
			String userDTOAddress, 
			int userDTOAddressNumber,
			int userDTOAddressFloor, 
			String userDTOAddressApartment, 
			UUID countryId, 
			UUID provinceId, 
			UUID cityId) {
		this.userId = userId;
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
	
	public UUID getUserId() {
		return userId;
	}
	
	public void setUserId(UUID userId) {
		this.userId = userId;
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
	
	public LocalDate getUserDTOBirthDate() {
		return userDTOBirthDate;
	}
	
	public void setUserDTOBirthDate(LocalDate userDTOBirthDate) {
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
	
	public int getUserDTOAddressNumber() {
		return userDTOAddressNumber;
	}
	
	public void setUserDTOAddressNumber(int userDTOAddressNumber) {
		this.userDTOAddressNumber = userDTOAddressNumber;
	}
	
	public int getUserDTOAddressFloor() {
		return userDTOAddressFloor;
	}
	
	public void setUserDTOAddressFloor(int userDTOAddressFloor) {
		this.userDTOAddressFloor = userDTOAddressFloor;
	}
	
	public String getUserDTOAddressApartment() {
		return userDTOAddressApartment;
	}
	
	public void setUserDTOAddressApartment(String userDTOAddressApartment) {
		this.userDTOAddressApartment = userDTOAddressApartment;
	}
	
	public UUID getCountryId() {
		return countryId;
	}
	
	public void setCountryId(UUID countryId) {
		this.countryId = countryId;
	}
	
	public UUID getProvinceId() {
		return provinceId;
	}
	
	public void setProvinceId(UUID provinceId) {
		this.provinceId = provinceId;
	}
	
	public UUID getCityId() {
		return cityId;
	}
	
	public void setCityId(UUID cityId) {
		this.cityId = cityId;
	}
	
}