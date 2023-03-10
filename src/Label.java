import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
    Label(String name) {
        this.setText(name);
        this.setBackground(new Color(51,51,51));
        this.setForeground(new Color(220,220,220));
        this.setFont(new Font("Times New Roman", Font.BOLD, 14));
        this.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        this.setAlignmentY(JLabel.BOTTOM_ALIGNMENT);
    }
    
}