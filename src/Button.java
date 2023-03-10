import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Button extends JButton implements MouseListener {
    Button(String text, ImageIcon icon) {
        this.setBackground(new Color(51, 51, 51));
        this.setFocusable(false);
        this.setFont(new Font("Times New Roman", Font.BOLD, 20));
        this.setAlignmentX(JButton.LEFT_ALIGNMENT);
        this.setHorizontalTextPosition(JButton.RIGHT);
        this.setIconTextGap(10);
        this.setForeground(Color.white);
        this.setBorder(null);
        this.addMouseListener(this);
        this.setContentAreaFilled(true);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        
        this.setIcon(icon);
        this.setText(text);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {  
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this) {
            this.setBackground(new Color(38,38,38));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this) {
            this.setBackground(new Color(64,64,64));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this) {
            this.setBackground(new Color(51,51,51));
        }
    }
    
}
