package therapist_desktopJavaApp.model.entity;

import java.util.UUID;

public class Province { 
    private UUID provinceId;
    private String provinceName;
    private UUID countryId;
    
	public Province(UUID provinceId, String provinceName, UUID countryId) {
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.countryId = countryId;
	}

	public UUID getProvinceId() {
		return this.provinceId;
	}
	
	public String getProvinceName() {
		return this.provinceName;
	}
	
	public UUID getCountryId() {
		return this.countryId;
	}
}