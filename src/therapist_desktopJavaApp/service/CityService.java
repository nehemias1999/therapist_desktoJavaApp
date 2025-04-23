package therapist_desktopJavaApp.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.model.dao.CityDAO;
import therapist_desktopJavaApp.model.dto.in.CityDTOIN;

public class CityService {
	private CityDAO cityDAO;
	
    public CityService() {
		this.cityDAO = new CityDAO();
	}

	public List<CityDTOIN> getCitiesByProvinceId(String provinceId) {
        return cityDAO.findCitiesByProvinceId(UUID.fromString(provinceId)).stream()
        		.map(c -> new CityDTOIN(c.getCityId().toString(), c.getCityName(), c.getCityZIPCode(), c.getProvinceId().toString()))
        		.collect(Collectors.toList());
    }

}
