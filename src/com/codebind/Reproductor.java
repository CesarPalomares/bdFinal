package com.codebind;

import javax.swing.*;

public class Reproductor {
    private JPanel panel1;
    private JButton playButton;
    private JButton button2;
    private JButton rebobinarButton;
    private JLabel name;
    private JLabel gene;

    JFrame frame = new JFrame("Reproductor");

    String nombre;
    String genero;

    public Reproductor(String nombre, String genero){
        this.nombre=nombre;
        this.genero=genero;

        this.name.setText(nombre);
        this.gene.setText(genero);
    }

    public void iniciar(){
        this.frame.setContentPane(new Reproductor(this.nombre,this.genero).panel1);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(300,450);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }
}
