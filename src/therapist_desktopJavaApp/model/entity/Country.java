package therapist_desktopJavaApp.model.entity;

import java.util.UUID;

public class Country {
	private UUID countryId;
	private String countryName;
	
	public Country(UUID countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public UUID getCountryId() {
		return countryId;
	}

	public void setCountryId(UUID countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
