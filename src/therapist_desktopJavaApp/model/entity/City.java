package therapist_desktopJavaApp.model.entity;

public class City {
    private int cityId;
    private String cityName;
    private String cityZIPCode;
    private int provinceId;

	public City(int cityId, String cityName, String cityZIPCode, int provinceId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityZIPCode = cityZIPCode;
		this.provinceId = provinceId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityZIPCode() {
		return cityZIPCode;
	}

	public void setCityZIPCode(String cityZIPCode) {
		this.cityZIPCode = cityZIPCode;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
		
}