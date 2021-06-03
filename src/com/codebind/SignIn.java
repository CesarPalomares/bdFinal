package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn {

    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton cancelarButton;
    private JButton registrarmeButton;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner1;

    static JFrame frame = new JFrame("Registro MusiCore");

    static Conexion c1 = new Conexion();

    public SignIn() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        registrarmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = String.valueOf(passwordField1.getPassword());
                String p2 = String.valueOf(passwordField2.getPassword());

                String fecha = spinner1.getValue().toString()+"-"+spinner2.getValue().toString()+"-"+spinner3.getValue().toString();

                if (!textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals("") && !textField4.getText().equals("")
                && !p1.equals("") && !p2.equals("")){

                    if (p1.equals(p2)) {
                        c1.registrarUsuario(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), p1, fecha);
                        System.out.println("Registro efectuado");
                        JOptionPane.showMessageDialog(frame,"Registro Efectuado");
                        frame.dispose();
                    }else{
                        //System.out.println("Los campos de contraseña no coinciden!");
                        JOptionPane.showMessageDialog(frame,"Los campos de contraseña no coinciden!");
                    }
                }else{
                    //System.out.println("Por favor rellene los campos correctamente.");
                    JOptionPane.showMessageDialog(frame,"Por favor rellene los campos correctamente.");
                }
            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new SignIn().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void iniciar(){
        frame.setContentPane(new SignIn().panel1);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800,400);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
