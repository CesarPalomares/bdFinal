package com.codebind;

import javax.swing.*;

public class Inicio {
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;
    private JList list1;
    private JCheckBox popCheckBox;
    private JCheckBox rockCheckBox;
    private JCheckBox reggaetonCheckBox;
    private JCheckBox otrosCheckBox;
    private JLabel user;

    static JFrame frame = new JFrame("Sputufui");

    public Inicio(String usr){
        user.setText("Usuario: "+usr);
    }

    public static void main(String[] args) {
        frame.setContentPane(new Inicio().panel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
