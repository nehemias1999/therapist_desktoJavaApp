package therapist_desktopJavaApp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import therapist_desktopJavaApp.view.MainFRM;
import therapist_desktopJavaApp.exception.ValidationException;
import therapist_desktopJavaApp.model.dto.in.CityDTOIN;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;
import therapist_desktopJavaApp.view.LoadPatientPNL;
import therapist_desktopJavaApp.view.MainMenuPNL;
import therapist_desktopJavaApp.view.ViewCalendarPNL;

public class ViewManager {
	
	private Controller controller;
	
	// Frame principal
	
	private MainFRM mainFRM;

	// Paneles
	
    private MainMenuPNL pnlMainMenu;
    private LoadPatientPNL pnlLoadPatient;
    private ViewCalendarPNL pnlViewCalendar;

	public ViewManager(Controller controller) {
		this.controller = controller;
		this.mainFRM = new MainFRM();
			
		addPanels();
		
		mainFRM.setVisible(true);
		
	}
	
	private void addPanels() {
		pnlMainMenu = new MainMenuPNL(this);
		pnlLoadPatient = new LoadPatientPNL(this);
		pnlViewCalendar = new ViewCalendarPNL(this);
		
		mainFRM.addPanel(pnlMainMenu, "MainMenu");
		mainFRM.addPanel(pnlLoadPatient, "LoadPatient");
		mainFRM.addPanel(pnlViewCalendar, "ViewCalendar");
	}
		
	public void showPnlMainMenu() {
		mainFRM.showPanel("MainMenu");
	}

	public void showPnlLoadPatient() {
		mainFRM.showPanel("LoadPatient");
	}
	
	public List<CountryDTOIN> getAllCountriesDTO() {
		return controller.getAllCountriesDTO();
	}
	
	public List<ProvinceDTOIN> getProvincesDTOByCountryId(String countryId) {
		return controller.getProvincesDTOByCountryId(countryId);
	}
		
	public List<CityDTOIN> getCitiesDTOByProvinceId(String provinciaId) {
		return controller.getCitiesDTOByProvinceId(provinciaId);
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
			String cityId) throws SQLException, ValidationException {
		
		controller.insertPatient(
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
        		cityId);
		
	}
	
	public void showPnlViewCalendar() {
		mainFRM.showPanel("ViewCalendar");
	}
	
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(
            mainFRM,                    
            message,                 
            "Error",              
            JOptionPane.ERROR_MESSAGE  
        );
    }

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(
            mainFRM,                    
            message,                 
            "Exito",              
            JOptionPane.OK_OPTION
        );
    }
    
    public void showInformationMessage(String message) {
        JOptionPane.showMessageDialog(
            mainFRM,
            message,
            "Información",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
	
}