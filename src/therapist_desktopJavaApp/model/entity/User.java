package therapist_desktopJavaApp.model.entity;

import java.time.LocalDate;

public class User {
    private String userDNI;
    private String userName;
    private String userLastName;
    private LocalDate userBirthDate;
    private String userEmail;
    private String userAddress;
    private int userAddressNumber;
    private Integer userAddressFloor;
    private String userAddressApartment;
    private int countryId;
    private int provinceId;
    private int cityId;

	public User(String userDNI, String userName, String userLastName, LocalDate userBirthDate, String userEmail,
			String userAddress, int userAddressNumber, Integer userAddressFloor, String userAddressApartment,
			int countryId, int provinceId, int cityId) {
		super();
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

	public Integer getUserAddressFloor() {
		return userAddressFloor;
	}

	public void setUserAddressFloor(Integer userAddressFloor) {
		this.userAddressFloor = userAddressFloor;
	}

	public String getUserAddressApartment() {
		return userAddressApartment;
	}

	public void setUserAddressApartment(String userAddressApartment) {
		this.userAddressApartment = userAddressApartment;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
