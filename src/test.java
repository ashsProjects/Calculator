import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class test {
    static ImageIcon helpIcon = Main.changeIconSize(new ImageIcon("src\\help_icon.png"), 20, 20);

    public static void main(String[] args) throws IOException {
        Frame frame = new Frame();
        JButton deleteHistory = new JButton("Delete History");
        deleteHistory.setBackground(new Color(51, 51, 51));
        deleteHistory.setForeground(Color.white);
        deleteHistory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        deleteHistory.setBorder(null);
        deleteHistory.setHorizontalAlignment(SwingConstants.CENTER);
        deleteHistory.setFocusable(false);
        deleteHistory.setBounds(5, 260, 130, 20);
        deleteHistory.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all of your history?",
                    "Delete History", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == 1 || option == -1 || option == 2) {
            } else {
                File file = new File("history.txt");
                if (file.delete())
                    JOptionPane.showMessageDialog(null, "Successfully deleted!");
                else
                    JOptionPane.showMessageDialog(null, "Failed to delete the file.", "Error", 2);
            }

        });

        frame.add(deleteHistory);
        frame.setVisible(true);
    }

}
