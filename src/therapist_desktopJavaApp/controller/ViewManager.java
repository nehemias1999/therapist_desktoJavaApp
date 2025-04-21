package therapist_desktopJavaApp.controller;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JPanel;

import therapist_desktopJavaApp.view.MainFRM;
import therapist_desktopJavaApp.model.dto.in.CityDTOIN;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;
import therapist_desktopJavaApp.view.LoadUserPNL;
import therapist_desktopJavaApp.view.MainMenuPNL;
import therapist_desktopJavaApp.view.ViewCalendarPNL;

public class ViewManager {
	
	private Controller controller;
	
	// Frame principal
	
	private MainFRM mainFRM;

	// Paneles
	
    private MainMenuPNL pnlMainMenu;
    private LoadUserPNL pnlLoadUser;
    private ViewCalendarPNL pnlViewCalendar;

	public ViewManager(Controller controller) {
		this.controller = controller;
		this.mainFRM = new MainFRM();
			
		addPanels();
		
		mainFRM.setVisible(true);
		
	}
	
	private void addPanels() {
		pnlMainMenu = new MainMenuPNL(this);
		pnlLoadUser = new LoadUserPNL(this);
		pnlViewCalendar = new ViewCalendarPNL(this);
		
		mainFRM.addPanel(pnlMainMenu, "MainMenu");
		mainFRM.addPanel(pnlLoadUser, "LoadUser");
		mainFRM.addPanel(pnlViewCalendar, "ViewCalendar");
	}
		
	public void showPnlMainMenu() {
		mainFRM.showPanel("MainMenu");
	}

	public void showPnlLoadUser() {
		mainFRM.showPanel("LoadUser");
	}
	
	public List<CountryDTOIN> getAllCountriesDTO() {
		return controller.getAllCountriesDTO();
	}
	
	public List<ProvinceDTOIN> getProvincesDTOByCountryId(int countryId) {
		return controller.getProvincesDTOByCountryId(countryId);
	}
		
	public List<CityDTOIN> getCitiesDTOByProvinceId(int provinciaId) {
		return controller.getCitiesDTOByProvinceId(provinciaId);
	}
	
	public void loadUser(
		  String documento,
          String nombre,
          String apellido,
          String fechaNac,
          String email,
          String direccion,
          String altura,
          String piso,
          String departamento,
          String countryId,
          String provinceId,
          String cityId) {
		
	}
	
	public void showPnlViewCalendar() {
		mainFRM.showPanel("ViewCalendar");
	}
	
}