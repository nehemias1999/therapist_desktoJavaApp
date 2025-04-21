package therapist_desktopJavaApp.model.entity;

import java.time.LocalDate;
import java.util.UUID;

public class User {
	private UUID userId;
    private String userDNI;
    private String userName;
    private String userLastName;
    private LocalDate userBirthDate;
    private String userEmail;
    private String userAddress;
    private int userAddressNumber;
    private int userAddressFloor;
    private String userAddressApartment;
    private UUID countryId;
    private UUID provinceId;
    private UUID cityId;

	public User(
			UUID userId,
			String userDNI, 
			String userName, 
			String userLastName, 
			LocalDate userBirthDate, 
			String userEmail,
			String userAddress, 
			int userAddressNumber, 
			int userAddressFloor, 
			String userAddressApartment,
			UUID countryId, 
			UUID provinceId, 
			UUID cityId) {
		this.userId = userId;
		this.userDNI = userDNI;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userBirthDate = userBirthDate;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userAddressNumber = userAddressNumber;
		this.userAddressFloor = userAddressFloor;
		this.userAddressApartment = userAddressApartment;
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
    
	public String getUserDNI() {
		return userDNI;
	}

	public void setUserDNI(String userDNI) {
		this.userDNI = userDNI;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public LocalDate getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(LocalDate userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserAddressNumber() {
		return userAddressNumber;
	}

	public void setUserAddressNumber(int userAddressNumber) {
		this.userAddressNumber = userAddressNumber;
	}

	public int getUserAddressFloor() {
		return userAddressFloor;
	}

	public void setUserAddressFloor(int userAddressFloor) {
		this.userAddressFloor = userAddressFloor;
	}

	public String getUserAddressApartment() {
		return userAddressApartment;
	}

	public void setUserAddressApartment(String userAddressApartment) {
		this.userAddressApartment = userAddressApartment;
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
