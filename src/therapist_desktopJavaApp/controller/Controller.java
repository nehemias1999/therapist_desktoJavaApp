package therapist_desktopJavaApp.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import therapist_desktopJavaApp.model.dto.in.CityDTOIN;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;
import therapist_desktopJavaApp.model.dto.in.UserDTOIN;
import therapist_desktopJavaApp.service.CityService;
import therapist_desktopJavaApp.service.CountryService;
import therapist_desktopJavaApp.service.ProvinceService;
import therapist_desktopJavaApp.service.UserService;

public class Controller {

	private CountryService countryService;
	private ProvinceService provinceService;
	private CityService cityService;
	private UserService userService;
	
    private ViewManager viewManager;
    
    public Controller() {
    	this.countryService = new CountryService();
    	this.provinceService = new ProvinceService();
    	this.cityService = new CityService();
    	this.userService = new UserService();
    			
    	viewManager = new ViewManager(this);
    	
        this.initView();
    }
    
    private void initView() {
        viewManager.showPnlMainMenu();
    }

    public List<CountryDTOIN> getAllCountriesDTO() {
    	return countryService.getAllCountries();
    }
    
    public List<ProvinceDTOIN> getProvincesDTOByCountryId(UUID countryId) {
    	return provinceService.getProvincesByCountryId(countryId);
    }

    public List<CityDTOIN> getCitiesDTOByProvinceId(UUID provinceId) {
        return cityService.getCitiesByProvinceId(provinceId);
    }

    /**
     * Valida y guarda un nuevo usuario.
     * @param documento documento del usuario
     * @param nombre nombre
     * @param apellido apellido
     * @param fechaNac fecha de nacimiento en formato yyyy-MM-dd
     * @param email email
     * @param direccion dirección
     * @param numero número de domicilio
     * @param piso piso
     * @param departamento departamento
     * @param provinciaId identificador de la provincia seleccionada
     * @param ciudadId identificador de la ciudad seleccionada
     * @throws SQLException 
     */
    
    public void loadUser(
    		String userDNI, 
			String userName, 
			String userLastName, 
			String userBirthDate, 
			String userEmail,
			String userAddress, 
			String userAddressNumber, 
			String userAddressFloor, 
			String userAddressApartment,
			String countryId, 
			String provinceId, 
			String cityId
    ) throws SQLException {
        
        if (!userDNI.matches("\\d{8}")) {
            //showErrorMessage("El número de documento debe tener 8 dígitos."); return;
        }
        if (userName.isEmpty() || userName.length()>50) {
            //showErrorMessage("Nombre inválido."); return;
        }
        if (userLastName.isEmpty() || userLastName.length()>50) {
            //showErrorMessage("Apellido inválido."); return;
        }
        if (!userEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            //showErrorMessage("Email inválido."); return;
        }
        if (userAddress.isEmpty() || userAddress.length()>50) {
            //showErrorMessage("Dirección inválida."); return;
        }
        
        userService.loadUser(new UserDTOIN(userDNI, userName, userLastName, userBirthDate, userEmail, userAddress, userAddressNumber, userAddressFloor, userAddressApartment, countryId, provinceId, cityId));
        
    }
    
}