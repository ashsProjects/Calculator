import javax.swing.*;

import java.awt.*;

public class Frame extends JFrame{
    ImageIcon image = new ImageIcon("src\\calculator_icon.png");
    Frame() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setAlwaysOnTop(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(38, 38, 38));
        this.setIconImage(image.getImage());
    }
}
