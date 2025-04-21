package therapist_desktopJavaApp.model.entity;

public class Province { 
    private int provinceId;
    private String provinceName;
    private int countryId;
    
	public Province(int provinceId, String provinceName, int countryId) {
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.countryId = countryId;
	}

	public int getProvinceId() {
		return this.provinceId;
	}
	
	public String getProvinceName() {
		return this.provinceName;
	}
	
	public int getCountryId() {
		return this.countryId;
	}
}