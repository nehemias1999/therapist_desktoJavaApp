package therapist_desktopJavaApp.model.dto.in;

public class CountryDTOIN {
	private String countryDTOId;
	private String countryDTOName;
	
	public CountryDTOIN(String countryDTOId, String countryDTOName) {
		this.countryDTOId = countryDTOId;
		this.countryDTOName = countryDTOName;
	}
	
	public String getCountryDTOId() {
		return countryDTOId;
	}
	
	public void setCountryDTOId(String countryDTOId) {
		this.countryDTOId = countryDTOId;
	}
	
	public String getCountryDTOName() {
		return countryDTOName;
	}
	
	public void setCountryDTOName(String countryDTOName) {
		this.countryDTOName = countryDTOName;
	}
		
}
