package com.codebind;

import java.sql.*;

public class Conexion {
    static Connection con;

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal","root","1a2b3c4d");

            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/proyectoFinal","root","1a2b3c4d");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String buscarUsuarios(String nombre){
        String salida = null;
        try {
            Statement st = con.createStatement();
            String query = "SELECT usuario FROM usuarios WHERE usuario='"+nombre+"'";

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                salida=rs.getString("usuario");
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return salida;
    }

    public static String buscarContrasena(String nombre){
        String salida = null;
        try {
            Statement st = con.createStatement();
            String query = "SELECT contrasena FROM usuarios WHERE usuario='"+nombre+"'";

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                salida=rs.getString("contrasena");
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return salida;
    }

    public void registrarUsuario(String nombre, String apellidos, String correo, String usuario, String contrasena, String fecha){
        try{
            Statement st = con.createStatement();
            String query = "INSERT INTO usuarios(usuario, contrasena, nombre, apellidos, fecha_nacimiento, correo) VALUES('"+usuario+"','"+contrasena+"','"+nombre+"','"+apellidos+"','"+fecha+"','"+correo+"')";

            st.execute(query);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void cerrarCon(){
        try{
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
