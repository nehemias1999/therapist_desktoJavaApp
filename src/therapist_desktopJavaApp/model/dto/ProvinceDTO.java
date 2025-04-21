package therapist_desktopJavaApp.model.dto;

public class ProvinceDTO {
	private int ProvinceDTOId;
    private String provinceDTOName;
    private int countryId;
    
	public ProvinceDTO(int provinceDTOId, String provinceDTOName, int countryId) {
		this.ProvinceDTOId = provinceDTOId;
		this.provinceDTOName = provinceDTOName;
		this.countryId = countryId;
	}
	
	public int getProvinceDTOId() {
		return ProvinceDTOId;
	}
	
	public void setProvinceDTOId(int provinceDTOId) {
		ProvinceDTOId = provinceDTOId;
	}
	
	public String getProvinceDTOName() {
		return provinceDTOName;
	}
	
	public void setProvinceDTOName(String provinceDTOName) {
		this.provinceDTOName = provinceDTOName;
	}
    
	public int getCountryId() {
		return countryId;
	}
}
