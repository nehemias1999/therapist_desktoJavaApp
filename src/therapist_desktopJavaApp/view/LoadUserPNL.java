package therapist_desktopJavaApp.view;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.UUID;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.UtilDateModel;

import therapist_desktopJavaApp.controller.ViewManager;
import therapist_desktopJavaApp.model.dto.out.CityDTOOUT;
import therapist_desktopJavaApp.model.dto.out.CountryDTOOUT;
import therapist_desktopJavaApp.model.dto.out.ProvinceDTOOUT;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

public class LoadUserPNL extends JPanel {
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
    private JComboBox<CountryDTOOUT> comboCountry;
    private JComboBox<ProvinceDTOOUT> comboProvince;
    private JComboBox<CityDTOOUT> comboCity;

    public LoadUserPNL(ViewManager viewManager) {
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
        comboCountry = new JComboBox<>();
        comboProvince = new JComboBox<>();
        comboCity = new JComboBox<>();
        
        comboProvince.setEnabled(false);
        comboCity.setEnabled(false);
        
        // Valor por defecto para ciudad al inicio
        comboProvince.addItem(new ProvinceDTOOUT(0, "Seleccionar...", 0));
        comboCity.addItem(new CityDTOOUT(0, "Seleccionar...", "", 0));

        // Renderers
        comboCountry.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value instanceof CountryDTOOUT ? ((CountryDTOOUT) value).getCountryDTOName() : "");
                return this;
            }
        });
        
        comboProvince.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value instanceof ProvinceDTOOUT ? ((ProvinceDTOOUT) value).getProvinceDTOName() : "");
                return this;
            }
        });
        
        comboCity.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value instanceof CityDTOOU ? ((CityDTOOUT) value).getCityDTOName() : "");
                return this;
            }
        });

        loadCountries();
        
        // Seleccionar valor por defecto al inicio
        comboCountry.setSelectedIndex(0);
        comboCountry.addActionListener(e -> {
            CountryDTOOUT country = (CountryDTOOUT) comboCountry.getSelectedItem();
            if (country != null && country.getCountryDTOId() > 0) {
                loadProvinces(country.getCountryDTOId());
                comboProvince.setEnabled(true);
            } else {
                comboProvince.removeAllItems();
                comboProvince.addItem(new ProvinceDTOOUT(0, "Seleccionar...", 0));
                comboProvince.setEnabled(false);
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
                        LoadUserPNL.this,
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
        addRow(formPanel, gbc, row++, "Pais:", comboCountry);
        addRow(formPanel, gbc, row++, "Provincia:", comboProvince);
        addRow(formPanel, gbc, row++, "Ciudad:", comboCity);

        JPanel center = new JPanel(new GridBagLayout());
        center.add(formPanel);
        add(center, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
        JButton guardar = new JButton("Guardar");
        JButton volver = new JButton("Volver al Inicio");
        guardar.addActionListener(e->loadUser());
        volver.addActionListener(e->viewManager.showPnlMainMenu());
        btnPanel.add(guardar);
        btnPanel.add(volver);
        add(btnPanel, BorderLayout.SOUTH);
    }
    
    private void loadCountries() {
        comboCountry.removeAllItems();
        comboCountry.addItem(new CountryDTOOUT("0,"Seleccionar..."));
        for (CountryDTOOUT cdto : viewManager.getAllCountriesDTO()) comboCountry.addItem(cdto);
    }

    private void loadProvinces(int countryId) {
        comboProvince.removeAllItems();
        comboProvince.addItem(new ProvinceDTOOUT("0,"Seleccionar...",0));
        for (ProvinceDTOOUT pdto : viewManager.getProvincesDTOByCountryId(countryId)) comboProvince.addItem(pdto);
    }

    private void loadCities(int provinceId) {
        comboCity.removeAllItems();
        comboCity.addItem(new CityDTOOUT("0","Seleccionar...","",provinceId));
        for (CityDTOOUT cdto: viewManager.getCitiesDTOByProvinceId(provinceId)) comboCity.addItem(cdto);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc,int row,String label,JComponent comp) {
        gbc.gridy=row; gbc.gridx=0; panel.add(new JLabel(label,SwingConstants.RIGHT),gbc);
        gbc.gridx=1; panel.add(comp,gbc);
    }

    private void loadUser() {
 
        viewManager.loadUser(
            txtDocumento.getText().trim(),
            txtNombre.getText().trim(),
            txtApellido.getText().trim(),
            datePicker.getJFormattedTextField().getText(),
            txtEmail.getText().trim(),
            txtDireccion.getText().trim(),
            txtNumero.getText().trim(),
            txtPiso.getText().trim(),
            txtDepartamento.getText().trim(),
            String.valueOf(((CountryDTOOUT)comboCountry.getSelectedItem()).getCountryDTOId()),
            String.valueOf(((ProvinceDTOOUT)comboProvince.getSelectedItem()).getProvinceDTOId()),
            String.valueOf(((CityDTOOUT)comboCity.getSelectedItem()).getCityDTOId())
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