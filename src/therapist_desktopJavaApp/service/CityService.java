package therapist_desktopJavaApp.service;

import java.util.List;
import java.util.stream.Collectors;

import therapist_desktopJavaApp.model.dao.CityDAO;
import therapist_desktopJavaApp.model.dto.CityDTO;

public class CityService {
	private CityDAO cityDAO;
	
    public CityService() {
		this.cityDAO = new CityDAO();
	}

	public List<CityDTO> getCitiesByProvinceId(int provinceId) {
        return cityDAO.findCitiesByProvinceId(provinceId).stream()
        		.map(c -> new CityDTO(c.getCityId(), c.getCityName(), c.getCityZIPCode(), c.getProvinceId()))
        		.collect(Collectors.toList());
    }

}
