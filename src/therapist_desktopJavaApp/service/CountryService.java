package therapist_desktopJavaApp.service;

import java.util.List;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.model.dao.CountryDAO;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;

public class CountryService {
	private CountryDAO countryDAO;
		
    public CountryService() {
		this.countryDAO = new CountryDAO();
	}

	public List<CountryDTOIN> getAllCountries() {
        return countryDAO.findAllCountries().stream()
    			.map(p -> new CountryDTOIN(p.getCountryId().toString(), p.getCountryName()))
    			.collect(Collectors.toList());
    }
	
}
