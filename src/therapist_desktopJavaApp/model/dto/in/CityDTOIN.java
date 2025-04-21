package therapist_desktopJavaApp.model.dto.in;

public class CityDTOIN {
    private String cityDTOId;
    private String cityDTOName;
    private String cityDTOZIPCode;
    private String provinceId;

    public CityDTOIN() {}

    public CityDTOIN(String cityDTOId, String cityDTOName, String cityDTOZIPCode, String provinceId) {
        this.cityDTOId = cityDTOId;
        this.cityDTOName = cityDTOName;
        this.cityDTOZIPCode = cityDTOZIPCode;
        this.provinceId = provinceId;
    }

	public String getCityDTOId() {
		return cityDTOId;
	}

	public void setCityDTOId(String cityDTOId) {
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

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
    
}
