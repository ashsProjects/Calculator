import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class History extends JPanel {
    static ImageIcon histIcon = Main.changeIconSize(new ImageIcon("src\\history_icon.png"), 20, 20);
    public static Map<String, String> list = new HashMap<>();
    static JScrollPane sp;
    static JTable table;
    static DefaultTableModel model;

    History() throws IOException {
        getFromFile();

        this.setVisible(true);
        this.setLayout(null);
        this.setBounds(10, 130, 140, 300);
        this.setBackground(new Color(60, 60, 60));

        JLabel histLabel = new JLabel("History");
        histLabel.setIcon(histIcon);
        histLabel.setIconTextGap(10);
        histLabel.setFocusable(false);
        histLabel.setBackground(new Color(51, 51, 51));
        histLabel.setForeground(Color.white);
        histLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        histLabel.setBounds(10, 10, 150, 20);
        histLabel.setIconTextGap(5);
        histLabel.setHorizontalAlignment(SwingConstants.LEFT);
        // -----Add keys to column----------------
        LinkedList<String> keys = new LinkedList<>();
        for (String key : list.keySet()) {
            keys.addFirst(key);
        }

        model = new DefaultTableModel();
        model.addColumn("Header", keys.toArray());
        table = new JTable(model);
        table.setTableHeader(null);
        table.setBackground(new Color(60, 60, 60));
        table.setForeground(Color.white);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        table.setShowGrid(false);
        table.setRowHeight(25);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                String valueAtClick = table.getValueAt(row, column).toString();
                if (row >= 0 && column >= 0) {
                    JOptionPane.showMessageDialog(null,
                            String.format(valueAtClick + "\n\n" + getValueFromKey(valueAtClick)),
                            "History", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        sp = new JScrollPane(table);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setBounds(5, 40, 130, 240);
        sp.getViewport().setBackground(new Color(60, 60, 60));

        JButton deleteHistory = new JButton("Delete History");
        deleteHistory.setBackground(new Color(60, 60, 60));
        deleteHistory.setForeground(Color.white);
        deleteHistory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        deleteHistory.setBorder(null);
        deleteHistory.setHorizontalAlignment(SwingConstants.CENTER);
        deleteHistory.setFocusable(false);
        deleteHistory.setBounds(5, 278, 130, 20);
        deleteHistory.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all of your history?",
                    "Delete History", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == 1 || option == -1 || option == 2) {
            } else {
                File file = new File("history.txt");
                if (file.delete()) {
                    JOptionPane.showMessageDialog(null, "Successfully deleted!");
                } else
                    JOptionPane.showMessageDialog(null, "Failed to delete the file.", "Error", 2);
            }

        });
        deleteHistory.addMouseListener(new MouseAdapter() {
            Color orig = deleteHistory.getBackground();

            public void mouseEntered(MouseEvent e) {
                deleteHistory.setBackground(deleteHistory.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                deleteHistory.setBackground(orig);
            }
        });

        this.add(deleteHistory);
        this.add(sp);
        this.add(histLabel);

    }

    public static void add(String key, String val) throws IOException {
        list.put(key, val);
        addToFile(key, val);
        model.insertRow(0, new String[] { key });
    }

    public static void addToFile(String key, String val) throws IOException {
        File file = new File("history.txt");
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : list.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } finally {
            bf.close();
        }
    }

    public void getFromFile() throws IOException {
        File file = new File("history.txt");
        if (file.exists()) {
            Scanner scnr = new Scanner(file);
            while (scnr.hasNextLine()) {
                String data = scnr.nextLine();
                String key = data.substring(0, data.indexOf(":"));
                String value = data.substring(data.indexOf(":") + 1);

                list.put(key, value);
            }
        } else
            return;
    }

    public static String getValueFromKey(String str) {
        String val = "";
        for (Map.Entry<String, String> entry : list.entrySet()) {
            if (str.equals(entry.getKey()))
                val = entry.getValue();
        }
        if (val.contains("[")) {
            val = val.replaceAll("[]]", "\n");
            val = val.replaceAll("[\\[,\\]]", "");
        }
        return val;
    }
}
