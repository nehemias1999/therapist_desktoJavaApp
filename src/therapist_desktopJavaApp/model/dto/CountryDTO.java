package therapist_desktopJavaApp.model.dto;

public class CountryDTO {
	private int countryDTOId;
	private String countryDTOName;
	
	public CountryDTO(int countryDTOId, String countryDTOName) {
		super();
		this.countryDTOId = countryDTOId;
		this.countryDTOName = countryDTOName;
	}
	
	public int getCountryDTOId() {
		return countryDTOId;
	}
	
	public void setCountryDTOId(int countryDTOId) {
		this.countryDTOId = countryDTOId;
	}
	
	public String getCountryDTOName() {
		return countryDTOName;
	}
	
	public void setCountryDTOName(String countryDTOName) {
		this.countryDTOName = countryDTOName;
	}
		
}
