package therapist_desktopJavaApp.service;

import java.util.List;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.model.dao.CountryDAO;
import therapist_desktopJavaApp.model.dto.CountryDTO;

public class CountryService {
	private CountryDAO countryDAO;
		
    public CountryService() {
		this.countryDAO = new CountryDAO();
	}

	public List<CountryDTO> getAllCountries() {
        return countryDAO.findAllCountries().stream()
    			.map(p -> new CountryDTO(p.getCountryId(), p.getCountryName()))
    			.collect(Collectors.toList());
    }
	
}
