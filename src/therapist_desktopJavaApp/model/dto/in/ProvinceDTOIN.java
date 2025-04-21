package therapist_desktopJavaApp.model.dto.in;

public class ProvinceDTOIN {
	private String ProvinceDTOId;
    private String provinceDTOName;
    private String countryId;
    
	public ProvinceDTOIN(String provinceDTOId, String provinceDTOName, String countryId) {
		this.ProvinceDTOId = provinceDTOId;
		this.provinceDTOName = provinceDTOName;
		this.countryId = countryId;
	}
	
	public String getProvinceDTOId() {
		return ProvinceDTOId;
	}
	
	public void setProvinceDTOId(String provinceDTOId) {
		ProvinceDTOId = provinceDTOId;
	}
	
	public String getProvinceDTOName() {
		return provinceDTOName;
	}
	
	public void setProvinceDTOName(String provinceDTOName) {
		this.provinceDTOName = provinceDTOName;
	}
    
	public String getCountryId() {
		return countryId;
	}
}
