import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.IOException;

public class StandardPanel extends JPanel {
    static ImageIcon helpIcon = Main.changeIconSize(new ImageIcon("src\\help_icon.png"), 25, 25);
    static String userInput = "";

    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
    static JButton button0;
    static JButton add;
    static JButton subtract;
    static JButton multiply;
    static JButton divide;
    static JButton equals;
    static JButton square;
    static JButton squareRoot;
    static JButton decimal;
    static JButton negativePositive;
    static JButton clear;

    StandardPanel() {
        this.setVisible(false);
        this.setLayout(null);
        this.setBounds(170, 10, 300, 420);
        this.setBackground(new Color(38, 38, 38));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Standard Calculator", TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 20), new Color(220, 220, 220)));
        
        JButton helpLabel = new JButton(helpIcon);
        helpLabel.setContentAreaFilled(false);
        helpLabel.setFocusPainted(false);
        helpLabel.setBorderPainted(false);
        helpLabel.setBounds(180, -2, 30, 30);
        helpLabel.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Use the numbers tab to enter a number\nUse the +/- button to enter a negative value" + 
                "\nUse the decimal button to enter decimal values\nUse the +, -, x, ÷ signs to do their respective operations" +
                "\nUse the √x to calculate square root \n\t\t*(Press √x 1st then enter the number) ex. √x then 8" + 
                "\nUse the x² to calculate squares \n\t\t*(Press x² 1st then enter the number) ex. x² then 1" +
                "\nAfter inputting all values and operation signs, press the equals button" + 
                "\nYour result will be shown in the main screen \nThe screen at the top visualizes the inputs" + 
                "\nUse the clear button to clear your current input\n\nHave fun!", "Help Menu for Standard Calculator", 1);
        });

        JTextField calculationsScreen = new JTextField();
        calculationsScreen.setBackground(new Color(38, 38, 38));
        calculationsScreen.setForeground(Color.white);
        calculationsScreen.setFont(new Font("Times New Roman", Font.BOLD, 16));
        calculationsScreen.setHorizontalAlignment(JTextField.RIGHT);
        calculationsScreen.setFocusable(true);
        calculationsScreen.setBounds(10, 30, 280, 30);
        calculationsScreen.setBorder(null);
        calculationsScreen.setEditable(false);

        JTextField resultScreen = new JTextField();
        resultScreen.setBackground(new Color(38, 38, 38));// new Color(38, 38, 38));
        resultScreen.setForeground(Color.white);
        resultScreen.setText("0");
        resultScreen.setFont(new Font("Times New Roman", Font.BOLD, 65));
        resultScreen.setHorizontalAlignment(JTextField.RIGHT);
        resultScreen.setFocusable(false);
        resultScreen.setBounds(10, 55, 280, 60);
        resultScreen.setBorder(null);
        resultScreen.setEditable(false);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBounds(10, 130, 280, 280);
        buttonPanel.setBackground(new Color(38, 38, 38));
        buttonPanel.setBorder(null);

        button1 = new JButton("1");
        button1.setBackground(new Color(77, 77, 77));
        button1.setFocusable(false);
        button1.setForeground(Color.white);
        button1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button1.setBorder(null);
        button1.addMouseListener(new MouseAdapter() {
            Color orig = button1.getBackground();

            public void mouseEntered(MouseEvent e) {
                button1.setBackground(button1.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button1.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "1";
                calculationsScreen.setText(userInput);
            }
        });

        button2 = new JButton("2");
        button2.setBackground(new Color(77, 77, 77));
        button2.setFocusable(false);
        button2.setForeground(Color.white);
        button2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button2.setBorder(null);
        button2.addMouseListener(new MouseAdapter() {
            Color orig = button2.getBackground();

            public void mouseEntered(MouseEvent e) {
                button2.setBackground(button2.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button2.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "2";
                calculationsScreen.setText(userInput);
            }
        });

        button3 = new JButton("3");
        button3.setBackground(new Color(77, 77, 77));
        button3.setFocusable(false);
        button3.setForeground(Color.white);
        button3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button3.setBorder(null);
        button3.addMouseListener(new MouseAdapter() {
            Color orig = button3.getBackground();

            public void mouseEntered(MouseEvent e) {
                button3.setBackground(button3.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button3.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "3";
                calculationsScreen.setText(userInput);
            }
        });

        button4 = new JButton("4");
        button4.setBackground(new Color(77, 77, 77));
        button4.setFocusable(false);
        button4.setForeground(Color.white);
        button4.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button4.setBorder(null);
        button4.addMouseListener(new MouseAdapter() {
            Color orig = button4.getBackground();

            public void mouseEntered(MouseEvent e) {
                button4.setBackground(button4.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button4.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "4";
                calculationsScreen.setText(userInput);
            }
        });

        button5 = new JButton("5");
        button5.setBackground(new Color(77, 77, 77));
        button5.setFocusable(false);
        button5.setForeground(Color.white);
        button5.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button5.setBorder(null);
        button5.addMouseListener(new MouseAdapter() {
            Color orig = button5.getBackground();

            public void mouseEntered(MouseEvent e) {
                button5.setBackground(button5.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button5.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "5";
                calculationsScreen.setText(userInput);
            }
        });

        button6 = new JButton("6");
        button6.setBackground(new Color(77, 77, 77));
        button6.setFocusable(false);
        button6.setForeground(Color.white);
        button6.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button6.setBorder(null);
        button6.addMouseListener(new MouseAdapter() {
            Color orig = button6.getBackground();

            public void mouseEntered(MouseEvent e) {
                button6.setBackground(button6.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button6.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "6";
                calculationsScreen.setText(userInput);
            }
        });

        button7 = new JButton("7");
        button7.setBackground(new Color(77, 77, 77));
        button7.setFocusable(false);
        button7.setForeground(Color.white);
        button7.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button7.setBorder(null);
        button7.addMouseListener(new MouseAdapter() {
            Color orig = button7.getBackground();

            public void mouseEntered(MouseEvent e) {
                button7.setBackground(button7.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button7.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "7";
                calculationsScreen.setText(userInput);
            }
        });

        button8 = new JButton("8");
        button8.setBackground(new Color(77, 77, 77));
        button8.setFocusable(false);
        button8.setForeground(Color.white);
        button8.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button8.setBorder(null);
        button8.addMouseListener(new MouseAdapter() {
            Color orig = button8.getBackground();

            public void mouseEntered(MouseEvent e) {
                button8.setBackground(button8.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button8.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "8";
                calculationsScreen.setText(userInput);
            }
        });

        button9 = new JButton("9");
        button9.setBackground(new Color(77, 77, 77));
        button9.setFocusable(false);
        button9.setForeground(Color.white);
        button9.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button9.setBorder(null);
        button9.addMouseListener(new MouseAdapter() {
            Color orig = button9.getBackground();

            public void mouseEntered(MouseEvent e) {
                button9.setBackground(button9.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button9.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "9";
                calculationsScreen.setText(userInput);
            }
        });

        button0 = new JButton("0");
        button0.setBackground(new Color(77, 77, 77));
        button0.setFocusable(false);
        button0.setForeground(Color.white);
        button0.setFont(new Font("Times New Roman", Font.BOLD, 30));
        button0.setBorder(null);
        button0.addMouseListener(new MouseAdapter() {
            Color orig = button0.getBackground();

            public void mouseEntered(MouseEvent e) {
                button0.setBackground(button0.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                button0.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "0";
                calculationsScreen.setText(userInput);
            }
        });

        add = new JButton("+");
        add.setBackground(new Color(51, 51, 51));
        add.setFocusable(false);
        add.setForeground(Color.white);
        add.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add.setBorder(null);
        add.addMouseListener(new MouseAdapter() {
            Color orig = add.getBackground();

            public void mouseEntered(MouseEvent e) {
                add.setBackground(add.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                add.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += " + ";
                calculationsScreen.setText(userInput);
            }
        });

        subtract = new JButton("-");
        subtract.setBackground(new Color(51, 51, 51));
        subtract.setFocusable(false);
        subtract.setForeground(Color.white);
        subtract.setFont(new Font("Times New Roman", Font.BOLD, 30));
        subtract.setBorder(null);
        subtract.addMouseListener(new MouseAdapter() {
            Color orig = subtract.getBackground();

            public void mouseEntered(MouseEvent e) {
                subtract.setBackground(subtract.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                subtract.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += " - ";
                calculationsScreen.setText(userInput);
            }
        });

        multiply = new JButton("x");
        multiply.setBackground(new Color(51, 51, 51));
        multiply.setFocusable(false);
        multiply.setForeground(Color.white);
        multiply.setFont(new Font("Times New Roman", Font.BOLD, 30));
        multiply.setBorder(null);
        multiply.addMouseListener(new MouseAdapter() {
            Color orig = multiply.getBackground();

            public void mouseEntered(MouseEvent e) {
                multiply.setBackground(multiply.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                multiply.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += " x ";
                calculationsScreen.setText(userInput);
            }
        });

        divide = new JButton("÷");
        divide.setBackground(new Color(51, 51, 51));
        divide.setFocusable(false);
        divide.setForeground(Color.white);
        divide.setFont(new Font("Times New Roman", Font.BOLD, 30));
        divide.setBorder(null);
        divide.addMouseListener(new MouseAdapter() {
            Color orig = divide.getBackground();

            public void mouseEntered(MouseEvent e) {
                divide.setBackground(divide.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                divide.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += " ÷ ";
                calculationsScreen.setText(userInput);
            }
        });

        equals = new JButton("=");
        equals.setBackground(new Color(51, 204, 255));
        equals.setFocusable(false);
        equals.setForeground(Color.white);
        equals.setFont(new Font("Times New Roman", Font.BOLD, 30));
        equals.setBorder(null);
        equals.addMouseListener(new MouseAdapter() {
            Color orig = equals.getBackground();

            public void mouseEntered(MouseEvent e) {
                equals.setBackground(equals.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                equals.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                String total = calculateTotal(userInput);
                calculationsScreen.setText(userInput + " =");
                resultScreen.setText(total);
                //calculationsScreen.requestFocusInWindow();
                //calculationsScreen.selectAll();
                try {
                    History.add(calculationsScreen.getText(), total);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                userInput = "";
            }

            private String calculateTotal(String userInput) {
                boolean multOrDiv = true;
                
                try {
                if (!userInput.contains(" "))
                    return userInput;
                
                if (userInput.contains("x") && userInput.contains("÷")) {
                    if (userInput.indexOf("x") > userInput.indexOf("÷")) multOrDiv = false;
                    //false for division, true for multiplication
                }
        
                if (userInput.contains("sqr ")) {
                    String front = userInput.substring(0, userInput.indexOf("sqr "));
                    String back = "";
                    String input = "";
                    int checkEnd = userInput.indexOf(" ", userInput.indexOf("sqr ") + 4);
        
                    if (checkEnd == -1) {
                        input = userInput.substring(userInput.indexOf("sqr") + 4);
                    } else {
                        back = userInput.substring(userInput.indexOf(" ", userInput.indexOf("sqr ") + 4));
                        input = userInput.substring(userInput.indexOf("sqr ") + 4,
                                userInput.indexOf(" ", userInput.indexOf("sqr ") + 4));
                    }
        
                    double dblInput = Double.parseDouble(input);
                    String resultInput = Double.toString(Math.pow(dblInput, 2));
        
                    return calculateTotal(front.concat(resultInput).concat(back));
                }
        
                if (userInput.contains("sqrt ")) {
                    String front = userInput.substring(0, userInput.indexOf("sqrt"));
                    String back = "";
                    String input = "";
                    int checkEnd = userInput.indexOf(" ", userInput.indexOf("sqrt") + 5);
        
                    if (checkEnd == -1) {
                        input = userInput.substring(userInput.indexOf("sqrt") + 5);
                    } else {
                        back = userInput.substring(userInput.indexOf(" ", userInput.indexOf("sqrt") + 5));
                        input = userInput.substring(userInput.indexOf("sqrt") + 5,
                                userInput.indexOf(" ", userInput.indexOf("sqrt") + 5));
                    }
        
                    double dblInput = Double.parseDouble(input);
                    String resultInput = String.format("%.2f", (Math.sqrt(dblInput)));
        
                    return calculateTotal(front.concat(resultInput).concat(back));
        
                }
        
                if (userInput.contains("x") && multOrDiv) {
                    String firstNum = findPrevNumber(userInput.substring(0, userInput.indexOf("x")));
                    int prevNumIndex = userInput.indexOf(firstNum);
                    String front = userInput.substring(0, prevNumIndex);
                    String back = "";
                    String secondNum = "";
                    int checkEnd = userInput.indexOf(" ", userInput.indexOf("x") + 2);
        
                    if (checkEnd == -1) {
                        secondNum = userInput.substring(userInput.indexOf("x") + 2);
                    } else {
                        back = userInput.substring(userInput.indexOf(" ", userInput.indexOf("x") + 2));
                        secondNum = userInput.substring(userInput.indexOf("x") + 2,
                                userInput.indexOf(" ", userInput.indexOf("x") + 2));
                    }
        
                    double firstDbl = Double.parseDouble(firstNum);
                    double secondDbl = Double.parseDouble(secondNum);
        
                    String resultInput = Double.toString(firstDbl * secondDbl);
        
                    return calculateTotal(front.concat(resultInput).concat(back));
        
                }
        
                if (userInput.contains("÷")) {
                    String firstNum = findPrevNumber(userInput.substring(0, userInput.indexOf("÷")));
                    int prevNumIndex = userInput.indexOf(firstNum);
                    String front = userInput.substring(0, prevNumIndex);
                    String back = "";
                    String secondNum = "";
                    int checkEnd = userInput.indexOf(" ", userInput.indexOf("÷") + 2);
        
                    if (checkEnd == -1) {
                        secondNum = userInput.substring(userInput.indexOf("÷") + 2);
                    } else {
                        back = userInput.substring(userInput.indexOf(" ", userInput.indexOf("÷") + 2));
                        secondNum = userInput.substring(userInput.indexOf("÷") + 2,
                                userInput.indexOf(" ", userInput.indexOf("÷") + 2));
                    }
        
                    double firstDbl = Double.parseDouble(firstNum);
                    double secondDbl = Double.parseDouble(secondNum);
        
                    String resultInput = Double.toString(firstDbl / secondDbl);
        
                    return calculateTotal(front.concat(resultInput).concat(back));
        
                }
        
                if (userInput.contains("+")) {
                    String firstNum = findPrevNumber(userInput.substring(0, userInput.indexOf("+")));
                    int prevNumIndex = userInput.indexOf(firstNum);
                    String front = userInput.substring(0, prevNumIndex);
                    String back = "";
                    String secondNum = "";
                    int checkEnd = userInput.indexOf(" ", userInput.indexOf("+") + 2);
        
                    if (checkEnd == -1) {
                        secondNum = userInput.substring(userInput.indexOf("+") + 2);
                    } else {
                        back = userInput.substring(userInput.indexOf(" ", userInput.indexOf("+") + 2));
                        secondNum = userInput.substring(userInput.indexOf("+") + 2,
                                userInput.indexOf(" ", userInput.indexOf("+") + 2));
                    }
        
                    double firstDbl = Double.parseDouble(firstNum);
                    double secondDbl = Double.parseDouble(secondNum);
        
                    String resultInput = Double.toString(firstDbl + secondDbl);
        
                    return calculateTotal(front.concat(resultInput).concat(back));
        
                }
        
                if (userInput.contains(" - ")) {
                    String firstNum = findPrevNumber(userInput.substring(0, userInput.indexOf(" - ") + 1));
                    int prevNumIndex = userInput.indexOf(firstNum);
                    String front = userInput.substring(0, prevNumIndex);
                    String back = "";
                    String secondNum = "";
                    int checkEnd = userInput.indexOf(" ", userInput.indexOf(" - ") + 3);
        
                    if (checkEnd == -1) {
                        secondNum = userInput.substring(userInput.indexOf(" - ") + 3);
                    } else {
                        back = userInput.substring(userInput.indexOf(" ", userInput.indexOf(" - ") + 3));
                        secondNum = userInput.substring(userInput.indexOf(" - ") + 3,
                                userInput.indexOf(" ", userInput.indexOf(" - ") + 3));
                    }
        
                    double firstDbl = Double.parseDouble(firstNum);
                    double secondDbl = Double.parseDouble(secondNum);
        
                    String resultInput = Double.toString(firstDbl - secondDbl);
        
                    return calculateTotal(front.concat(resultInput).concat(back));
        
                }
    
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something went wrong.\nPlease check your input and try again.\nIf you need help, check the features tab.", "Error", 2);
            }
            return userInput;
            
            }//end calculateTotal method

            private String findPrevNumber(String str) {
                int i = str.length() - 2;
                String s = "";
                while (i >= 0 && str.charAt(i) != ' ') {
                    s = str.charAt(i) + s;
                    i--;
                }
                return s;
            }
        });//end inner class

        decimal = new JButton(".");
        decimal.setBackground(new Color(77, 77, 77));
        decimal.setFocusable(false);
        decimal.setForeground(Color.white);
        decimal.setFont(new Font("Times New Roman", Font.BOLD, 30));
        decimal.setBorder(null);
        decimal.addMouseListener(new MouseAdapter() {
            Color orig = decimal.getBackground();

            public void mouseEntered(MouseEvent e) {
                decimal.setBackground(decimal.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                decimal.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += ".";
                calculationsScreen.setText(userInput);
            }
        });

        negativePositive = new JButton("+/-");
        negativePositive.setBackground(new Color(77, 77, 77));
        negativePositive.setFocusable(false);
        negativePositive.setForeground(Color.white);
        negativePositive.setFont(new Font("Times New Roman", Font.BOLD, 30));
        negativePositive.setBorder(null);
        negativePositive.addMouseListener(new MouseAdapter() {
            Color orig = negativePositive.getBackground();

            public void mouseEntered(MouseEvent e) {
                negativePositive.setBackground(negativePositive.getBackground().darker());
            }

            public void mouseExited(MouseEvent e) {
                negativePositive.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "-";
                calculationsScreen.setText(userInput);
            }
        });

        clear = new JButton("C");
        clear.setBackground(new Color(51, 51, 51));
        clear.setFocusable(false);
        clear.setForeground(Color.white);
        clear.setFont(new Font("Times New Roman", Font.BOLD, 30));
        clear.setBorder(null);
        clear.addMouseListener(new MouseAdapter() {
            Color orig = clear.getBackground();

            public void mouseEntered(MouseEvent e) {
                clear.setBackground(clear.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                clear.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput = "";
                calculationsScreen.setText("");
                resultScreen.setText("0");
            }
        });

        square = new JButton("x²");
        square.setBackground(new Color(51, 51, 51));
        square.setFocusable(false);
        square.setForeground(Color.white);
        square.setFont(new Font("Times New Roman", Font.BOLD, 30));
        square.setBorder(null);
        square.addMouseListener(new MouseAdapter() {
            Color orig = square.getBackground();

            public void mouseEntered(MouseEvent e) {
                square.setBackground(square.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                square.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "sqr ";
                calculationsScreen.setText(userInput);
            }
        });

        squareRoot = new JButton("√x");
        squareRoot.setBackground(new Color(51, 51, 51));
        squareRoot.setFocusable(false);
        squareRoot.setForeground(Color.white);
        squareRoot.setFont(new Font("Times New Roman", Font.BOLD, 30));
        squareRoot.setBorder(null);
        squareRoot.addMouseListener(new MouseAdapter() {
            Color orig = squareRoot.getBackground();

            public void mouseEntered(MouseEvent e) {
                squareRoot.setBackground(squareRoot.getBackground().brighter());
            }

            public void mouseExited(MouseEvent e) {
                squareRoot.setBackground(orig);
            }

            public void mouseClicked(MouseEvent e) {
                userInput += "sqrt ";
                calculationsScreen.setText(userInput);
            }
        });

        buttonPanel.add(clear);
        buttonPanel.add(square);
        buttonPanel.add(squareRoot);
        buttonPanel.add(divide);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(multiply);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(subtract);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(add);
        buttonPanel.add(negativePositive);
        buttonPanel.add(button0);
        buttonPanel.add(decimal);
        buttonPanel.add(equals);

        this.add(buttonPanel);
        this.add(resultScreen);
        this.add(calculationsScreen);
        this.add(helpLabel);
        
    }
}