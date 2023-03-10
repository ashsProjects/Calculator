import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar{
    JMenuItem about;
    JMenuItem welcome;
    JMenuItem features;

    public MenuBar() {

        about = new JMenuItem("About");
        welcome = new JMenuItem("Welcome");

        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Version: 1.00\nAuthor: Ash Adhikari\nDate Created: 2/28/23\nName: Calculator App", "About", 1);
        });
        welcome.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Welcome to a calculator app I created!\n\nYou can select the standard or descriptive\noptions in the panel to view that calculator.\n\nThen, input your data values and see the results!",
                    "Welcome", 1);
        });

        about.setBackground(new Color(51,51,51));
        about.setForeground(new Color(220,220,220));
        about.setBorder(null);
        about.addMouseListener(new MouseAdapter() {
            Color orig = about.getBackground();

            public void mouseEntered(MouseEvent e) {
                about.setBackground(about.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                about.setBackground(orig);
            }
        });
        welcome.setBackground(new Color(51,51,51));
        welcome.setForeground(new Color(220,220,220));
        welcome.setBorder(null);
        welcome.addMouseListener(new MouseAdapter() {
            Color orig = welcome.getBackground();

            public void mouseEntered(MouseEvent e) {
                welcome.setBackground(welcome.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                welcome.setBackground(orig);
            }
        });
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setBackground(new Color(51,51,51));
        this.setForeground(new Color(51,51,51));
        this.setBorder(BorderFactory.createLineBorder(new Color(51,51,51)));
        
        this.add(welcome);  
        this.add(about);
    }

}

        
