package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reproductor {
    private JPanel panel1;
    private JButton playButton;
    private JButton button2;
    private JButton rebobinarButton;
    private JLabel name;
    private JLabel gene;
    private JTextPane textPane1;
    private JButton publicarButton;
    private JList list1;

    JFrame frame = new JFrame("Reproductor");

    String nombre;
    String genero;
    String user;

    Conexion c1 = new Conexion();

    public Reproductor(String nombre, String genero, String user){
        this.nombre=nombre;
        this.genero=genero;
        this.user=user;

        this.name.setText(nombre);
        this.gene.setText(genero);

        this.list1.setListData(c1.listaComentarios(c1.datosElemento(nombre,"id_elemento")).toArray());

        publicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.comentar(textPane1.getText(),Integer.parseInt(c1.buscarIdUsuarios(user)),Integer.parseInt(c1.datosElemento(nombre,"id_elemento")));
                textPane1.setText("");
                list1.setListData(c1.listaComentarios(c1.datosElemento(nombre,"id_elemento")).toArray());
            }
        });
    }

    public void iniciar(){
        this.frame.setContentPane(new Reproductor(this.nombre,this.genero, this.user).panel1);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(400,550);
        this.frame.setResizable(true);
        this.frame.setVisible(true);
    }
}
