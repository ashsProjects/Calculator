import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    static Button standardButton;
    static Button descriptiveButton;
    static JTextPane openingMessage;

    public static void main(String[] args) throws IOException {
        // ----Initialize Icons----
        ImageIcon standardIcon = changeIconSize(new ImageIcon("src\\standard.png"), 20, 20);
        ImageIcon descriptiveIcon = changeIconSize(new ImageIcon("src\\descriptive_icon.png"), 20, 20);

        // ----Initialize Jcomponents----
        Frame frame = new Frame();
        MenuBar menuBar = new MenuBar();
        StandardPanel standardPanel = new StandardPanel();
        Descriptive descriptive = new Descriptive();
        History hist = new History();

        UIManager.put("OptionPane.background", new Color(51, 51, 51));
        UIManager.put("Panel.background", new Color(51, 51, 51));
        UIManager.put("OptionPane.messageForeground", new Color(240, 240, 240));
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 12));

        JPanel optionsPanel = new JPanel(null);
        optionsPanel.setBackground(new Color(51, 51, 51));
        optionsPanel.setBounds(5, 5, 150, 430);

        // ----Labels for Selection Panel----
        Label calculatorLabel = new Label("Calculator");
        calculatorLabel.setBounds(10, 10, 140, 10);

        // ----Buttons for Selection Panel----
        standardButton = new Button("Standard", standardIcon);
        standardButton.setBounds(5, 35, 150, 30);
        standardButton.addActionListener(e -> {
            openingMessage.setVisible(false);
            descriptive.setVisible(false);
            standardPanel.setVisible(true);
        });

        descriptiveButton = new Button("Descriptive", descriptiveIcon);
        descriptiveButton.setBounds(5, 70, 150, 30);
        descriptiveButton.addActionListener(e -> {
            openingMessage.setVisible(false);
            standardPanel.setVisible(false);
            descriptive.setVisible(true);
        });

        openingMessage = new JTextPane();
        openingMessage.setBounds(170, 140, 300, 420);
        openingMessage.setBackground(new Color(38, 38, 38));
        openingMessage.setForeground(Color.white);
        openingMessage.setFont(new Font("Times New Roman", Font.BOLD, 14));
        openingMessage.setText(
                "\nSelect one of the tabs on the right to open the calculation screen." +
                        " For help, click on the help button next to the calculators.");
        StyledDocument doc = openingMessage.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        // --------Adds History pane------------------------

        // ----add components to Frame and set visible----
        optionsPanel.add(standardButton);
        optionsPanel.add(descriptiveButton);
        optionsPanel.add(calculatorLabel);

        frame.add(hist);
        frame.add(openingMessage);
        frame.add(descriptive);
        frame.add(standardPanel);
        frame.add(optionsPanel);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static ImageIcon changeIconSize(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);

        return icon;
    }
}
