package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JSpinner spinner1;
    private JSpinner spinner2;

    static JFrame frame = new JFrame("Sputufui");

    static String usuario = "test";

    public Inicio(String usr){
        this.usuario = usr;
        this.user.setText("Usuario: "+usr);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new Inicio(usuario).panel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void iniciar(){
        frame.setContentPane(new Inicio(usuario).panel1);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
