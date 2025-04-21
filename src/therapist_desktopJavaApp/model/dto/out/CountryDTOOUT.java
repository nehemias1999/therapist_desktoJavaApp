package therapist_desktopJavaApp.model.dto.out;

import java.util.UUID;

public class CountryDTOOUT {
	private UUID countryDTOId;
	private String countryDTOName;
	
	public CountryDTOOUT(UUID countryDTOId, String countryDTOName) {
		this.countryDTOId = countryDTOId;
		this.countryDTOName = countryDTOName;
	}
	
	public UUID getCountryDTOId() {
		return countryDTOId;
	}
	
	public void setCountryDTOId(UUID countryDTOId) {
		this.countryDTOId = countryDTOId;
	}
	
	public String getCountryDTOName() {
		return countryDTOName;
	}
	
	public void setCountryDTOName(String countryDTOName) {
		this.countryDTOName = countryDTOName;
	}
		
}