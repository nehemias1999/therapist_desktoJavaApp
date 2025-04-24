package therapist_desktopJavaApp.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class SidebarPNL extends JPanel {
    private boolean collapsed = false;
    private final CardLayout contentLayout;
    private final JPanel contentPanel;
    private final JPanel buttonContainer;
    private final JButton btnToggle;
    private final Map<String, JButton> menuButtons = new LinkedHashMap<>();

    public SidebarPNL(CardLayout contentLayout, JPanel contentPanel) {
        this.contentLayout = contentLayout;
        this.contentPanel = contentPanel;
        setLayout(new BorderLayout());
        setBackground(new Color(45, 45, 45));
        setPreferredSize(new Dimension(200, Integer.MAX_VALUE));

        // Toggle
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));
        top.setBackground(getBackground());
        btnToggle = new JButton("<");
        btnToggle.setPreferredSize(new Dimension(40,40));
        btnToggle.setFocusPainted(false);
        btnToggle.setBackground(new Color(60,63,65));
        btnToggle.setForeground(Color.WHITE);
        btnToggle.addActionListener(e -> toggle());
        top.add(btnToggle);
        add(top, BorderLayout.NORTH);

        // Contenedor de botones
        buttonContainer = new JPanel();
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
        buttonContainer.setBackground(getBackground());
        add(new JScrollPane(buttonContainer,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),
            BorderLayout.CENTER);
    }

    /**
     * Añade un botón al menú lateral que muestra icono y texto, y redirige al panel.
     * @param name  clave del panel y texto del botón
     * @param iconPath ruta en classpath (ej. "/icons/calendar.png")
     */
    public void addMenuItem(String name, String iconPath) {
        JButton btn = new JButton(name);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        btn.setFont(btn.getFont().deriveFont(Font.BOLD,14f));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(60,63,65));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       // btn.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        btn.setIconTextGap(10);
        
        btn.addActionListener(e -> contentLayout.show(contentPanel, name));
        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(75,78,80)); }
            public void mouseExited(MouseEvent e)  { btn.setBackground(new Color(60,63,65)); }
        });

        buttonContainer.add(btn);
        buttonContainer.add(Box.createVerticalStrut(10));
        menuButtons.put(name, btn);
        revalidate(); repaint();
    }

    private void toggle() {
        collapsed = !collapsed;
        int width = collapsed ? 60 : 200;
        setPreferredSize(new Dimension(width, getHeight()));
        btnToggle.setText(collapsed?">":"<");
        btnToggle.getParent().setLayout(new FlowLayout(collapsed?FlowLayout.CENTER:FlowLayout.RIGHT,5,5));

        // Ajustar texto de botones
        menuButtons.forEach((key,btn)->{
            btn.setText(collapsed?"":key);
            btn.setHorizontalAlignment(collapsed?SwingConstants.CENTER:SwingConstants.LEFT);
        });
        revalidate(); repaint();
    }
}
