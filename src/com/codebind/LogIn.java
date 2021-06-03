package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JButton registrarmeButton;

    static JFrame frame = new JFrame("Inicio De Sesión");

    static Conexion c1 = new Conexion();

    public LogIn() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparaUsuario();
            }
        });
        registrarmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn s1 = new SignIn();
                s1.iniciar();
            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new LogIn().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,200);
        frame.setVisible(true);


    }

    public void iniciar(){
        frame.setContentPane(new LogIn().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,200);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void comparaUsuario(){
        if (textField1.getText().equals(c1.buscarUsuarios(textField1.getText()))){
            String myPass=String.valueOf(passwordField1.getPassword());

            if (myPass.equals(c1.buscarContrasena(textField1.getText()))){
                System.out.println("Log In correcto");
            }else {
                System.out.println("Incorrecto");
                JOptionPane.showMessageDialog(frame,"Incorrecto");
            }
        }else{
            System.out.println("Incorrecto");
            JOptionPane.showMessageDialog(frame,"Incorrecto");
        }


    }

}
