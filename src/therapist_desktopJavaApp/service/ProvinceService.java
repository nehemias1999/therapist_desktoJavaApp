package therapist_desktopJavaApp.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.model.dao.ProvinceDAO;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;

public class ProvinceService {
	private ProvinceDAO provinceDAO;
	
    public ProvinceService() {
		this.provinceDAO = new ProvinceDAO();
	}

	public List<ProvinceDTOIN> getProvincesByCountryId(String countryId) {		
        return provinceDAO.findProvincesByCountryId(UUID.fromString(countryId)).stream()
    			.map(p -> new ProvinceDTOIN(p.getProvinceId().toString(), p.getProvinceName(), p.getCountryId().toString()))
    			.collect(Collectors.toList());
    }
	
}
