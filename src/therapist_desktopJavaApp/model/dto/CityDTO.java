package therapist_desktopJavaApp.model.dto;

public class CityDTO {
    private int cityDTOId;
    private String cityDTOName;
    private String cityDTOZIPCode;
    private int provinceId;

    public CityDTO() {}

    public CityDTO(int cityDTOId, String cityDTOName, String cityDTOZIPCode, int provinceId) {
        this.cityDTOId = cityDTOId;
        this.cityDTOName = cityDTOName;
        this.cityDTOZIPCode = cityDTOZIPCode;
        this.provinceId = provinceId;
    }

	public int getCityDTOId() {
		return cityDTOId;
	}

	public void setCityDTOId(int cityDTOId) {
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

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
    
}
