package therapist_desktopJavaApp.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import therapist_desktopJavaApp.controller.ViewManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MainMenuPNL extends JPanel {
	
	private ViewManager viewManager;

    private JButton btnLoadPatient;
    private JButton btnShowCalendar;
    private JButton btnExit;

    public MainMenuPNL(ViewManager viewManager) {
        this.viewManager = viewManager;
        setLayout(new BorderLayout());

        // Título de la aplicación
        
        JLabel lblMainTitle = new JLabel("agenda", SwingConstants.CENTER);
        lblMainTitle.setFont(new Font("SansSerif", Font.BOLD, 60));
        lblMainTitle.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
        add(lblMainTitle, BorderLayout.NORTH);

        // Panel central para los botones (distribución vertical con BoxLayout)
        
        JPanel pnlbuttons = new JPanel();
        pnlbuttons.setLayout(new BoxLayout(pnlbuttons, BoxLayout.Y_AXIS));

        Dimension btnSize = new Dimension(200, 60);
        Dimension exitBtnSize = new Dimension(150, 50);
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 22);

        // Creación de botones
        
        btnLoadPatient = new JButton("Cargar Usuario");
        btnShowCalendar = new JButton("Ver calendario");
        btnExit = new JButton("Salir");

        // Configuración común para los botones (excepto "Salir")
        
        JButton[] standardButtons = {btnLoadPatient, btnShowCalendar};
        for (JButton btn : standardButtons) {
            btn.setFont(buttonFont);
            btn.setPreferredSize(btnSize);
            btn.setMaximumSize(btnSize);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        // Configuración especial para el botón "Salir"
        
        btnExit.setFont(buttonFont);
        btnExit.setPreferredSize(exitBtnSize);
        btnExit.setMaximumSize(exitBtnSize);
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.WHITE);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlbuttons.add(Box.createVerticalGlue());
        pnlbuttons.add(btnLoadPatient);
        pnlbuttons.add(Box.createRigidArea(new Dimension(0, 20)));
        pnlbuttons.add(btnShowCalendar);
        pnlbuttons.add(Box.createRigidArea(new Dimension(0, 20)));
        pnlbuttons.add(btnExit);
        pnlbuttons.add(Box.createVerticalGlue());

        add(pnlbuttons, BorderLayout.CENTER);

        // Pie de página con información del creador y versión
        JLabel lblFooter = new JLabel("Creado por [Tu Nombre] - Versión 1.0", SwingConstants.CENTER);
        lblFooter.setFont(new Font("SansSerif", Font.ITALIC, 12));
        lblFooter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblFooter, BorderLayout.SOUTH);
        
        // Acciones de botones
        
        btnLoadPatient.addActionListener(e -> {
        	viewManager.showPnlLoadPatient(); 
        });

        btnShowCalendar.addActionListener(e -> {
        	viewManager.showPnlViewCalendar();
        });

        btnExit.addActionListener(e -> {
        	
            int response = JOptionPane.showConfirmDialog(
                MainMenuPNL.this,
                "¿Desea salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
            );
            
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            
        });
        
    }
    
}

