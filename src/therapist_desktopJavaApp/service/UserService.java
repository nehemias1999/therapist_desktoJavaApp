package therapist_desktopJavaApp.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

import therapist_desktopJavaApp.model.dao.UserDAO;
import therapist_desktopJavaApp.model.dto.in.UserDTOIN;
import therapist_desktopJavaApp.model.entity.User;

public class UserService {
	private UserDAO userDAO;
	
    public UserService() {
		this.userDAO = new UserDAO();
	}

	public void loadUser(UserDTOIN userDTO) throws SQLException {
		
		UUID userId = UUID.randomUUID();
	
		String userDNI = userDTO.getUserDTODNI();
		
		String userName = userDTO.getUserDTOName();
		
		String userLastName = userDTO.getUserDTOLastName();
		
		LocalDate userBirthDate = LocalDate.parse(userDTO.getUserDTOBirthDate());
		
		String userEmail = userDTO.getUserDTOEmail();
		
		String userAddress = userDTO.getUserDTOAddress();
		
		int userAddressNumber = Integer.parseInt(userDTO.getUserDTOAddressNumber());
		
		int userAddressFloor = Integer.parseInt(userDTO.getUserDTOAddressFloor());
		
		String userAddressApartment = userDTO.getUserDTOAddressApartment();
		
		UUID countryId = UUID.fromString(userDTO.getCountryId());
		
		UUID provinceId = UUID.fromString(userDTO.getProvinceId());
		
		UUID cityId = UUID.fromString(userDTO.getCityId());
		
		userDAO.save(new User(userId, userDNI, userName, userLastName, userBirthDate, userEmail, userAddress, userAddressNumber, userAddressFloor, userAddressApartment, countryId, provinceId, cityId));
    }
	
}
