package therapist_desktopJavaApp.model.entity;

import java.util.UUID;

public class City {
    private UUID cityId;
    private String cityName;
    private String cityZIPCode;
    private UUID provinceId;

	public City(UUID cityId, String cityName, String cityZIPCode, UUID provinceId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityZIPCode = cityZIPCode;
		this.provinceId = provinceId;
	}

	public UUID getCityId() {
		return cityId;
	}

	public void setCityId(UUID cityId) {
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

	public UUID getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(UUID provinceId) {
		this.provinceId = provinceId;
	}
		
}