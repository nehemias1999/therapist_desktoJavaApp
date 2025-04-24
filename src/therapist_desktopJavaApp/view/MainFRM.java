package therapist_desktopJavaApp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class MainFRM extends JFrame {
 
    private CardLayout cardLayout;
    private JPanel contentPanel;
    
    public MainFRM() {
    	
        super("Gestión Terapeutas");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(true);
        setLayout(new BorderLayout());
        
    }
     
    public void addPanel(JPanel panel, String panelName) {
        this.contentPanel.add(panel, panelName);
    }    

    public void showPanel(String panelName) {
        this.cardLayout.show(contentPanel, panelName);
    }
   
}
