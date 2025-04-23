package therapist_desktopJavaApp.view;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.UtilDateModel;

import therapist_desktopJavaApp.controller.ViewManager;
import therapist_desktopJavaApp.exception.ValidationException;
import therapist_desktopJavaApp.model.dto.in.CityDTOIN;
import therapist_desktopJavaApp.model.dto.in.CountryDTOIN;
import therapist_desktopJavaApp.model.dto.in.ProvinceDTOIN;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

public class LoadPatientPNL extends JPanel {
    private ViewManager viewManager;

    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JDatePickerImpl datePicker;
    private JTextField txtEdad;
    private JTextField txtEmail;
    private JTextField txtDireccion;
    private JTextField txtNumero;
    private JTextField txtPiso;
    private JTextField txtDepartamento;
    private JComboBox<CountryDTOIN> comboCountries;
    private JComboBox<ProvinceDTOIN> comboProvinces;
    private JComboBox<CityDTOIN> comboCities;

    public LoadPatientPNL(ViewManager viewManager) {
        this.viewManager = viewManager;
        setLayout(new BorderLayout(0, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel title = new JLabel("Cargar Usuario", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 36));
        add(title, BorderLayout.NORTH);

        // Inicializar componentes
        txtDocumento = new JTextField(15);
        txtNombre    = new JTextField(15);
        txtApellido  = new JTextField(15);
        txtEdad      = new JTextField(5);
        txtEdad.setEditable(false);
        txtEmail     = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtNumero    = new JTextField(5);
        txtPiso      = new JTextField(3);
        txtDepartamento = new JTextField(5);

        // Combos
        comboCountries = new JComboBox<>();
        comboProvinces = new JComboBox<>();
        comboCities = new JComboBox<>();
        
        comboProvinces.setEnabled(false);
        comboCities.setEnabled(false);
        
        // Valor por defecto para ciudad al inicio
        comboProvinces.addItem(new ProvinceDTOIN("", "Seleccionar...", ""));
        comboCities.addItem(new CityDTOIN("", "Seleccionar...", "", ""));

        // Renderers
        comboCountries.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value instanceof CountryDTOIN ? ((CountryDTOIN) value).getCountryDTOName() : "");
                return this;
            }
        });
        
        comboProvinces.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value instanceof ProvinceDTOIN ? ((ProvinceDTOIN) value).getProvinceDTOName() : "");
                return this;
            }
        });
        
        comboCities.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value instanceof CityDTOIN ? ((CityDTOIN) value).getCityDTOName() : "");
                return this;
            }
        });

        loadCountries();
        
        // Seleccionar valor por defecto al inicio
        comboCountries.setSelectedIndex(0);
        comboCountries.addActionListener(e -> {
            CountryDTOIN country = (CountryDTOIN) comboCountries.getSelectedItem();
            if (country != null && !country.getCountryDTOId().equals(new String(""))) {
                loadProvinces(country.getCountryDTOId());
                comboProvinces.setEnabled(true);
            } else {
                comboProvinces.removeAllItems();
                comboProvinces.addItem(new ProvinceDTOIN("", "Seleccionar...", ""));
                comboProvinces.setEnabled(false);
            }
        });
        
     // Seleccionar valor por defecto al inicio
        comboProvinces.setSelectedIndex(0);
        comboProvinces.addActionListener(e -> {
            ProvinceDTOIN province = (ProvinceDTOIN) comboProvinces.getSelectedItem();
            if (province != null && !province.getProvinceDTOId().equals(new String(""))) {
                loadCities(province.getProvinceDTOId());
                comboCities.setEnabled(true);
            } else {
                comboCities.removeAllItems();
                comboCities.addItem(new CityDTOIN("", "Seleccionar...", "", ""));
                comboCities.setEnabled(false);
            }
        });

        // Configurar JDatePicker
        UtilDateModel model = new UtilDateModel();
        model.setSelected(false);
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year",  "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        // Inicializar vacío
        datePicker.getJFormattedTextField().setText("");

        // Listener con addActionListener sobre el datePicker
        datePicker.addActionListener(e -> {
            Object val = datePicker.getModel().getValue();
            if (val instanceof Date) {
                LocalDate dob = Instant.ofEpochMilli(((Date) val).getTime())
                                     .atZone(ZoneId.systemDefault())
                                     .toLocalDate();
                if (dob.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(
                        LoadPatientPNL.this,
                        "No puede seleccionar una fecha futura.",
                        "Fecha Inválida",
                        JOptionPane.ERROR_MESSAGE
                    );
                    datePicker.getModel().setSelected(false);
                    datePicker.getJFormattedTextField().setText("");
                    txtEdad.setText("");
                } else {
                    String dateStr = new DateLabelFormatter().valueToString(dob);
                    datePicker.getJFormattedTextField().setText(dateStr);
                    txtEdad.setText(String.valueOf(Period.between(dob, LocalDate.now()).getYears()));
                }
            }
        });

        // Formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;
        int row = 0;
        addRow(formPanel, gbc, row++, "Documento:", txtDocumento);
        addRow(formPanel, gbc, row++, "Nombre:", txtNombre);
        addRow(formPanel, gbc, row++, "Apellido:", txtApellido);
        // Fecha+Edad
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(150,24));
        agePanel.add(datePicker);
        agePanel.add(new JLabel("Edad:"));
        agePanel.add(txtEdad);
        addRow(formPanel, gbc, row++, "Fecha Nacimiento:", agePanel);
        addRow(formPanel, gbc, row++, "Email:", txtEmail);
        addRow(formPanel, gbc, row++, "Dirección:", txtDireccion);
        // Número/Piso/Depto
        JPanel npd = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
        txtNumero.setPreferredSize(new Dimension(80,24));
        txtPiso.setPreferredSize(new Dimension(60,24));
        txtDepartamento.setPreferredSize(new Dimension(80,24));
        npd.add(txtNumero);
        npd.add(new JLabel("Piso:")); npd.add(txtPiso);
        npd.add(new JLabel("Depto:")); npd.add(txtDepartamento);
        addRow(formPanel, gbc, row++, "Número:", npd);
        addRow(formPanel, gbc, row++, "Pais:", comboCountries);
        addRow(formPanel, gbc, row++, "Provincia:", comboProvinces);
        addRow(formPanel, gbc, row++, "Ciudad:", comboCities);

        JPanel center = new JPanel(new GridBagLayout());
        center.add(formPanel);
        add(center, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        JButton guardar = new JButton("Guardar");
        JButton volver = new JButton("Volver al Inicio");
        guardar.addActionListener(e->{
			try {
				try {
					loadUser();
				} catch (ValidationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        volver.addActionListener(e->viewManager.showPnlMainMenu());
        btnPanel.add(guardar);
        btnPanel.add(volver);
        add(btnPanel, BorderLayout.SOUTH);
    }
    
    private void loadCountries() {
        comboCountries.removeAllItems();
        comboCountries.addItem(new CountryDTOIN("", "Seleccionar..."));
        for (CountryDTOIN cdto : viewManager.getAllCountriesDTO()) comboCountries.addItem(cdto);
    }

    private void loadProvinces(String countryId) {
        comboProvinces.removeAllItems();
        comboProvinces.addItem(new ProvinceDTOIN("", "Seleccionar...", ""));
        for (ProvinceDTOIN pdto : viewManager.getProvincesDTOByCountryId(countryId)) comboProvinces.addItem(pdto);
    }

    private void loadCities(String provinceId) {
        comboCities.removeAllItems();
        comboCities.addItem(new CityDTOIN("", "Seleccionar...", "", provinceId));
        for (CityDTOIN cdto: viewManager.getCitiesDTOByProvinceId(provinceId)) comboCities.addItem(cdto);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc,int row,String label,JComponent comp) {
        gbc.gridy=row; gbc.gridx=0; panel.add(new JLabel(label,SwingConstants.RIGHT),gbc);
        gbc.gridx=1; panel.add(comp,gbc);
    }

    private void loadUser() throws SQLException, ValidationException {
    	
        viewManager.insertPatient(
            txtDocumento.getText().trim(),
            txtNombre.getText().trim(),
            txtApellido.getText().trim(),
            datePicker.getJFormattedTextField().getText(),
            txtEmail.getText().trim(),
            txtDireccion.getText().trim(),
            txtNumero.getText().trim(),
            txtPiso.getText().trim(),
            txtDepartamento.getText().trim(),
            String.valueOf(((CountryDTOIN)comboCountries.getSelectedItem()).getCountryDTOId()),
            String.valueOf(((ProvinceDTOIN)comboProvinces.getSelectedItem()).getProvinceDTOId()),
            String.valueOf(((CityDTOIN)comboCities.getSelectedItem()).getCityDTOId())
        );
        
    }
    
    public void showErrorMessage() {
    	
    }
    
    public static class DateLabelFormatter extends AbstractFormatter {
        private final DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        @Override public Object stringToValue(String text){ return LocalDate.parse(text,dtf);} 
        @Override public String valueToString(Object value){
            if(value instanceof Date){
                Instant inst=((Date)value).toInstant();
                return dtf.format(inst.atZone(ZoneId.systemDefault()).toLocalDate());
            } else if(value instanceof LocalDate){
                return dtf.format((LocalDate)value);
            }
            return "";
        }
    }
}