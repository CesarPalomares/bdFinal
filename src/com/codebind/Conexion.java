package com.codebind;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public void registrarUsuario(String nombre, String apellidos, String correo, String usuario, String contrasena, String fecha, String paquete){
        LocalDate ld = LocalDate.now();

        System.out.println(paquete);

        if (paquete.equals("Basico")){
            ld = ld.plusMonths(2);
        }else if (paquete.equals("Intermedio")){
            ld = ld.plusYears(1);
        }else if (paquete.equals("Premium")){
            ld = ld.plusYears(1);
            ld = ld.plusMonths(6);
        }

        try{
            Statement st = con.createStatement();
            String query = "INSERT INTO usuarios(usuario, contrasena, nombre, apellidos, fecha_nacimiento, correo) VALUES('"+usuario+"','"+contrasena+"','"+nombre+"','"+apellidos+"','"+fecha+"','"+correo+"')";
            String query2 = "INSERT INTO subscritos(fecha_inicio,fecha_final) values(curdate(),'"+ld+"')";

            st.execute(query);
            st.execute(query2);


        }catch(Exception e){
            System.out.println(e);
        }
    }

    public ArrayList<String> listaMusica(String lk, ArrayList<String> generos){
        ArrayList<String> lista = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            String query = "SELECT * FROM elementos WHERE nombre LIKE '%"+lk+"%'";

            if (generos!=null){

                if (generos.size()==1){
                    query = "SELECT * FROM elementos WHERE nombre LIKE '%"+lk+"%' AND genero='"+ generos.get(0)+"'";
                }else if (generos.size()==2){
                    query = "SELECT * FROM elementos WHERE nombre LIKE '%"+lk+"%' AND genero='"+ generos.get(0) +"' OR genero='"+generos.get(1)+"'";
                }else if (generos.size()==3){
                    query = "SELECT * FROM elementos WHERE nombre LIKE '%"+lk+"%' AND genero='"+ generos.get(0) +"' OR genero='"+generos.get(1)+"'OR genero='"+generos.get(2)+"'";
                }else if(generos.size()==4){
                    query = "SELECT * FROM elementos WHERE nombre LIKE '%"+lk+"%' AND genero='"+ generos.get(0) +"' OR genero='"+generos.get(1)+"'OR genero='"+generos.get(2)+"' OR genero='"+generos.get(3)+"'";
                }
            }

            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                lista.add(rs.getString("nombre"));
            }


        }catch (Exception e){
            System.out.println(e);
        }

        return lista;
    }

    public String datosElemento(String nombre, String columna){
        String resultado = "";
        try{
            Statement st = con.createStatement();
            String query = "SELECT * FROM elementos WHERE nombre='"+nombre+"';";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                resultado=rs.getString(columna);
            }


        }catch (Exception e){
            System.out.println(e);
        }

        return resultado;
    }
}
