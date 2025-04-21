package therapist_desktopJavaApp.model.dto.out;

import java.util.UUID;

public class ProvinceDTOOUT {
	private UUID ProvinceDTOId;
    private String provinceDTOName;
    private UUID countryId;
    
	public ProvinceDTOOUT(UUID provinceDTOId, String provinceDTOName, UUID countryId) {
		this.ProvinceDTOId = provinceDTOId;
		this.provinceDTOName = provinceDTOName;
		this.countryId = countryId;
	}
	
	public UUID getProvinceDTOId() {
		return ProvinceDTOId;
	}
	
	public void setProvinceDTOId(UUID provinceDTOId) {
		ProvinceDTOId = provinceDTOId;
	}
	
	public String getProvinceDTOName() {
		return provinceDTOName;
	}
	
	public void setProvinceDTOName(String provinceDTOName) {
		this.provinceDTOName = provinceDTOName;
	}
    
	public UUID getCountryId() {
		return countryId;
	}
}