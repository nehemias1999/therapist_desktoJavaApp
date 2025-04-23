package therapist_desktopJavaApp.controller;

import java.sql.SQLException;
import java.util.List;

import therapist_desktopJavaApp.exception.ValidationException;
import therapist_desktopJavaApp.model.dto.in.CityDTOIN;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;
import therapist_desktopJavaApp.model.dto.in.PatientDTOIN;
import therapist_desktopJavaApp.service.CityService;
import therapist_desktopJavaApp.service.CountryService;
import therapist_desktopJavaApp.service.ProvinceService;
import therapist_desktopJavaApp.service.PatientService;

public class Controller {

	private CountryService countryService;
	private ProvinceService provinceService;
	private CityService cityService;
	private PatientService patientService;
	
    private ViewManager viewManager;
    
    public Controller() {
    	this.countryService = new CountryService();
    	this.provinceService = new ProvinceService();
    	this.cityService = new CityService();
    	this.patientService = new PatientService();
    			
    	viewManager = new ViewManager(this);
    	
        this.initView();
    }
    
    private void initView() {
        viewManager.showPnlMainMenu();
    }

    public List<CountryDTOIN> getAllCountriesDTO() {
    	return countryService.getAllCountries();
    }
    
    public List<ProvinceDTOIN> getProvincesDTOByCountryId(String countryId) {
    	return provinceService.getProvincesByCountryId(countryId);
    }

    public List<CityDTOIN> getCitiesDTOByProvinceId(String provinceId) {
        return cityService.getCitiesByProvinceId(provinceId);
    }

    public void insertPatient(
    		String patientDNI, 
			String patientName, 
			String patientLastName, 
			String patientBirthDate, 
			String patientEmail,
			String patientAddress, 
			String patientAddressNumber, 
			String patientAddressFloor, 
			String patientAddressApartment,
			String countryId, 
			String provinceId, 
			String cityId
    ) throws SQLException, ValidationException {
        
        if (!patientDNI.matches("\\d{8}")) {
            viewManager.showErrorMessage("Numero de documento ingresado invalido."); return;
        }
        
        if (patientName.isEmpty() || patientName.length()>50) {
        	viewManager.showErrorMessage("Nombre ingresado inválido."); return;
        }
        
        if (patientLastName.isEmpty() || patientLastName.length()>50) {
        	viewManager.showErrorMessage("Apellido ingresado inválido."); return;
        }
        
        if (patientBirthDate.isEmpty()) {
        	viewManager.showErrorMessage("Fecha de nacimiento ingresada inválida."); return;
        }
                
        if (!patientEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
        	viewManager.showErrorMessage("Email ingresado inválido."); return;
        }
        
        if (patientAddress.isEmpty() || patientAddress.length()>50) {
        	viewManager.showErrorMessage("Dirección ingresada inválida."); return;
        }
        
        if (patientAddressNumber.isEmpty()) {
        	viewManager.showErrorMessage("Numero de direccion ingresado inválido."); return;
        }
        
        if (countryId.isEmpty()) {
        	viewManager.showErrorMessage("Pais ingresado inválido."); return;
        }
        
        if (provinceId.isEmpty()) {
        	viewManager.showErrorMessage("Provincia ingresada inválida."); return;
        }
        
        if (cityId.isEmpty()) {
        	viewManager.showErrorMessage("Ciudad ingresada inválida."); return;
        }
        
        patientService.insertPatient(new PatientDTOIN(
        		patientDNI, 
        		patientName, 
        		patientLastName, 
        		patientBirthDate, 
        		patientEmail, 
        		patientAddress, 
        		patientAddressNumber, 
        		patientAddressFloor, 
        		patientAddressApartment, 
        		countryId, 
        		provinceId, 
        		cityId));
        
        viewManager.showSuccessMessage("Paciente ingresado exitosamente.");
        
    }
    
}