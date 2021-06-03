package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

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
    private JButton seleccionarButton;

    static JFrame frame = new JFrame("Sputufui");

    static String usuario = "test";

    Conexion c1 = new Conexion();

    public Inicio(String usr){
        this.usuario = usr;
        this.user.setText("Usuario: "+usr);

        this.list1.setListData(c1.listaMusica("", null).toArray());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> generos = new ArrayList<>();

                if (popCheckBox.isSelected()){
                    generos.add("Pop");
                }

                if (rockCheckBox.isSelected()){
                    generos.add("Rock");
                }
                if (reggaetonCheckBox.isSelected()){
                    generos.add("Reggaeton");
                }
                if (otrosCheckBox.isSelected()){
                    generos.add("Otros");
                }

                list1.setListData(c1.listaMusica(textField1.getText(),generos).toArray());
            }
        });
        list1.addComponentListener(new ComponentAdapter() {
        });
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reproductor r1 = new Reproductor(c1.datosElemento(list1.getSelectedValue().toString(),"nombre"), c1.datosElemento(list1.getSelectedValue().toString(),"genero"));
                r1.iniciar();
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
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}
