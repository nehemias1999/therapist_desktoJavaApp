package therapist_desktopJavaApp.service;

import java.util.List;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.model.dao.ProvinceDAO;
import therapist_desktopJavaApp.model.dto.ProvinceDTO;

public class ProvinceService {
	private ProvinceDAO provinceDAO;
	
    public ProvinceService() {
		this.provinceDAO = new ProvinceDAO();
	}

	public List<ProvinceDTO> getProvincesByCountryId(int countryId) {
        return provinceDAO.findProvincesByCountryId(countryId).stream()
    			.map(p -> new ProvinceDTO(p.getProvinceId(), p.getProvinceName(), p.getCountryId()))
    			.collect(Collectors.toList());
    }
	
}
