package therapist_desktopJavaApp.controller;

import java.util.List;

import therapist_desktopJavaApp.model.dto.CityDTO;
import therapist_desktopJavaApp.model.dto.CountryDTO;
import therapist_desktopJavaApp.model.dto.ProvinceDTO;
import therapist_desktopJavaApp.service.CityService;
import therapist_desktopJavaApp.service.CountryService;
import therapist_desktopJavaApp.service.ProvinceService;

public class Controller {

	private CountryService countryService;
	private ProvinceService provinceService;
	private CityService cityService;
	
    private ViewManager viewManager;
    
    public Controller() {
    	this.countryService = new CountryService();
    	this.provinceService = new ProvinceService();
    	this.cityService = new CityService();
    			
    	viewManager = new ViewManager(this);
    	
        this.initView();
    }
    
    private void initView() {
        viewManager.showPnlMainMenu();
    }

    public List<CountryDTO> getAllCountriesDTO() {
    	return countryService.getAllCountries();
    }
    
    public List<ProvinceDTO> getProvincesDTOByCountryId(int countryId) {
    	return provinceService.getProvincesByCountryId(countryId);
    }

    public List<CityDTO> getCitiesDTOByProvinceId(int provinceId) {
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
     */
//    
//    public void loadUser(
//            String documento,
//            String nombre,
//            String apellido,
//            String fechaNac,
//            String email,
//            String direccion,
//            String altura,
//            String piso,
//            String departamento,
//            String provinciaId,
//            String ciudadId
//    ) {
//        
////        if (!documento.matches("\\d{8}")) {
////            showErrorMessage("El número de documento debe tener 8 dígitos."); return;
////        }
////        if (nombre.isEmpty() || nombre.length()>50) {
////            showErrorMessage("Nombre inválido."); return;
////        }
////        if (apellido.isEmpty() || apellido.length()>50) {
////            showErrorMessage("Apellido inválido."); return;
////        }
////        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
////            showErrorMessage("Email inválido."); return;
////        }
////        if (direccion.isEmpty() || direccion.length()>50) {
////            showErrorMessage("Dirección inválida."); return;
//        }
//        
//        // Convertir a tipos de datos
//        
////        int intAltura = Integer.parseInt(altura);
////        int intPiso = Integer.parseInt(piso);
////        int intProvinciaId = Integer.parseInt(provinciaId);
////        int intCiudadId = Integer.parseInt(ciudadId);
//        
////        modelo.loadUser(documento, nombre, apellido, fechaNac, email, direccion, intAltura, intPiso, departamento, intProvinciaId, intCiudadId);
//        
//    }
    
}