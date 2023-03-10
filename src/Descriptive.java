import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.function.Function;
import java.util.stream.*;

public class Descriptive extends JPanel {
    static ImageIcon helpIcon = Main.changeIconSize(new ImageIcon("src\\help_icon.png"), 25, 25);
    static JTextArea directionlabel;
    static JTextField textField;
    static JButton submitButton;
    static JPanel resultsPanel;
    static JTable frequencyTable;
    static JTable statTable;

    Descriptive() {
        this.setVisible(false);
        this.setLayout(null);
        this.setBounds(170, 10, 300, 420);
        this.setBackground(new Color(38, 38, 38));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Descriptive Statistics", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 20), new Color(220, 220, 220)));

        JButton helpLabel = new JButton(helpIcon);
        helpLabel.setContentAreaFilled(false);
        helpLabel.setFocusPainted(false);
        helpLabel.setBorderPainted(false);
        helpLabel.setBounds(190, -2, 30, 30);
        helpLabel.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Enter your data values in the\ninput box (make sure to delete the\n" +
                    "initial message first).\n\nHit submit to see the sample statistics.\n\nYou might get an error message if you\nhave letters"
                    +
                    " in the your inputs or if \nthe textfield is empty.",
                    "Help Menu for Descriptive Calculator", 1);
        });

        directionlabel = new JTextArea();
        directionlabel.setBounds(10, 40, 280, 52);
        directionlabel.setBackground(new Color(38, 38, 38));
        directionlabel.setForeground(Color.white);
        directionlabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        directionlabel.setBorder(null);
        directionlabel.setLineWrap(true);
        directionlabel.setWrapStyleWord(true);
        directionlabel.setText("Enter your data values in the text box below followed by a comma" +
                " (ex. 12,45,23,09,12,23...)");

        textField = new JTextField();
        textField.setBounds(15, 110, 270, 30);
        textField.setText("Enter your values here...");
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textField.setForeground(new Color(100, 100, 100));

        JButton clearButton = new JButton("X");
        clearButton.requestFocusInWindow();
        clearButton.setContentAreaFilled(false);
        clearButton.setFocusPainted(false);
        clearButton.setBorderPainted(false);
        clearButton.setForeground(Color.black);
        clearButton.setBounds(250, 100, 50, 50);
        clearButton.addActionListener(e -> textField.setText(""));

        resultsPanel = new JPanel();
        resultsPanel.setBackground(new Color(50, 50, 50));
        resultsPanel.setBounds(15, 180, 270, 225);
        resultsPanel.setLayout(null);
        resultsPanel.setVisible(false);

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(110, 145, 80, 30);
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        submitButton.setFocusable(false);
        submitButton.addActionListener(e -> {
            String num = "";
            ArrayList<Double> list = new ArrayList<>();
            String input;
            try {
                input = textField.getText().trim();
                for (int i = 0; i < input.length(); i++) {
                    while (i < input.length() && input.charAt(i) != ',') {
                        num += input.charAt(i);
                        i++;
                    }
                    list.add(Double.parseDouble(num));
                    num = "";
                }
            } catch (Exception except) {
                JOptionPane.showMessageDialog(null,
                        "Something went wrong...\nPlease check your values and\ntry again. " +
                                "For help, click on the\nquestion mark next to the title.",
                        "Error", 2);
            }

            while (!list.isEmpty()) {
                Collections.sort(list);
                // ----------------------JTable and Frequency Table--------------------
                Map<Double, Integer> frequencyMap = list.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
                Object[][] frequencyArr = new Object[frequencyMap.size()][2];
                Set entries = frequencyMap.entrySet();
                Iterator entriesIterator = entries.iterator();
                int i = 0;
                while (entriesIterator.hasNext()) {
                    Map.Entry mapping = (Map.Entry) entriesIterator.next();
                    frequencyArr[i][0] = mapping.getKey();
                    frequencyArr[i][1] = mapping.getValue();
                    i++;
                }

                String[] columnNames = { "Value", "# Freq" };
                frequencyTable = new JTable(frequencyArr, columnNames);
                frequencyTable.setFont(new Font(null, Font.PLAIN, 13));
                frequencyTable.setShowGrid(false);
                frequencyTable.setAutoCreateRowSorter(true);
                frequencyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                frequencyTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                frequencyTable.getColumnModel().getColumn(1).setPreferredWidth(45);
                JScrollPane sp = new JScrollPane(frequencyTable);
                sp.setBounds(160, 10, 100, 200);
                // sp.getViewport().setBackground(new Color(50,50,50));

                resultsPanel.add(sp);

                // ----------------Calculating Sample Statistics with stream() -----------------
                Double min = list.get(0);
                Double max = list.get(list.size() - 1);
                Double count = (double) list.stream().mapToDouble(x -> x).count();
                Double mean = list.stream().mapToDouble(x -> x).average().getAsDouble();
                Double median = list.size() % 2 == 0
                        ? (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2
                        : list.get(list.size() / 2);
                Double sum = list.stream().mapToDouble(x -> x).sum();
                Double range = max - min;
                Double squaredDeviations = list.stream().mapToDouble(x -> Math.pow((x - mean), 2)).sum();
                Double variance = squaredDeviations / (count - 1);
                Double stDv = Math.sqrt(variance);
                Double q1 = list.stream().limit(list.size() / 2).mapToDouble(x -> x).sum() / (int) (count / 2);
                Double q3 = (list.size() / 2.0) % 2 == 0
                        ? list.stream().skip(list.size() / 2).mapToDouble(x -> x).sum() / (int) (count / 2)
                        : list.stream().skip(list.size() / 2 + 1).mapToDouble(x -> x).sum() / (int) (count / 2);
                Double IQR = q3 - q1;

                // -----Creating a 2D array with sample stats and adding to result panel---
                String[][] statArr = {
                        { "Count: ", count.toString() },
                        { "Min: ", min.toString() },
                        { "Q1: ", String.format("%.3f", q1) },
                        { "Median(x̃): ", median.toString() },
                        { "Q3: ", String.format("%.3f", q3) },
                        { "Max: ", max.toString() },
                        { "IQR: ", String.format("%.3f", IQR) },
                        { "Sum: ", String.format("%.3f", sum) },
                        { "Mean(x̅): ", String.format("%.3f", mean) },
                        { "Range: ", String.format("%.2f", range) },
                        { "Var(s²): ", String.format("%.3f", variance) },
                        { "St.Dev(s): ", String.format("%.3f", stDv) } };

                statTable = new JTable(statArr, columnNames);
                statTable.revalidate();
                statTable.requestFocusInWindow();
                statTable.setBackground(new Color(50, 50, 50));
                statTable.setForeground(Color.white);
                statTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                statTable.setShowGrid(false);
                statTable.setTableHeader(null);
                statTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                statTable.getColumnModel().getColumn(0).setPreferredWidth(80);
                statTable.getColumnModel().getColumn(1).setPreferredWidth(60);
                // statTable.setBounds(10, 5, 150, 210);

                JScrollPane sp2 = new JScrollPane(statTable);
                sp2.setBounds(10, 15, 143, 192);
                sp2.setBorder(BorderFactory.createEmptyBorder());

                resultsPanel.add(sp2);
                resultsPanel.setVisible(true);
                try {
                    History.add(textField.getText(), Arrays.deepToString(statArr));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                list.clear();
            } // end while loop

        });

        this.add(clearButton);
        this.add(helpLabel);
        this.add(directionlabel);
        this.add(textField);
        this.add(submitButton);
        this.add(resultsPanel);

    }
}