package therapist_desktopJavaApp.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import therapist_desktopJavaApp.controller.ViewManager;


public class ViewCalendarPNL extends JPanel {
    private ViewManager viewManager;

    public ViewCalendarPNL(ViewManager viewManager) {
        this.viewManager = viewManager;
        setLayout(new BorderLayout());

        // Título central del panel
        JLabel label = new JLabel("Agendar Cita", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 36));
        add(label, BorderLayout.CENTER);

        // Botón para volver al menú principal en la parte inferior
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnBack = new JButton("Volver al Inicio");
        bottomPanel.add(btnBack);
        add(bottomPanel, BorderLayout.SOUTH);

        btnBack.addActionListener(e -> {
            viewManager.showPnlMainMenu();
        });
    }
}

