package therapist_desktopJavaApp.model.dto.out;

import java.util.UUID;

public class CityDTOOUT {
    private UUID cityDTOId;
    private String cityDTOName;
    private String cityDTOZIPCode;
    private UUID provinceId;

    public CityDTOOUT() {}

    public CityDTOOUT(UUID cityDTOId, String cityDTOName, String cityDTOZIPCode, UUID provinceId) {
        this.cityDTOId = cityDTOId;
        this.cityDTOName = cityDTOName;
        this.cityDTOZIPCode = cityDTOZIPCode;
        this.provinceId = provinceId;
    }

	public UUID getCityDTOId() {
		return cityDTOId;
	}

	public void setCityDTOId(UUID cityDTOId) {
		this.cityDTOId = cityDTOId;
	}

	public String getCityDTOName() {
		return cityDTOName;
	}

	public void setCityDTOName(String cityDTOName) {
		this.cityDTOName = cityDTOName;
	}

	public String getCityDTOZIPCode() {
		return cityDTOZIPCode;
	}

	public void setCityDTOZIPCode(String cityDTOZIPCode) {
		this.cityDTOZIPCode = cityDTOZIPCode;
	}

	public UUID getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(UUID provinceId) {
		this.provinceId = provinceId;
	}
    
}
