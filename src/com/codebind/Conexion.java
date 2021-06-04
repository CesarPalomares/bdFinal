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
        int id_sus = 0;

        if (paquete.equals("Basico")){
            ld = ld.plusMonths(2);
            id_sus = 1;
        }else if (paquete.equals("Intermedio")){
            ld = ld.plusYears(1);
            id_sus = 2;
        }else if (paquete.equals("Premium")){
            ld = ld.plusYears(1);
            ld = ld.plusMonths(6);
            id_sus = 3;
        }

        try{
            Statement st = con.createStatement();
            String query = "CALL newUser('"+usuario+"','"+contrasena+"','"+nombre+"','"+apellidos+"','"+fecha+"','"+correo+"',"+id_sus+",'"+ld+"')";

            st.execute(query);

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

    public void copiaDeSeguridad(){
        try{
            Statement st = con.createStatement();
            String query="BACKUP DATABASE proyectofinal TO DISK = 'FinalDB\src\backup'";

            st.execute(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void comentar(String comentario, int id_usr, int id_elem){
        try{
            Statement st = con.createStatement();
            String query = "CALL comentar('"+comentario+"',"+id_usr+","+id_elem+")";

            st.execute(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String buscarIdUsuarios(String nombre){
        String salida = null;
        try {
            Statement st = con.createStatement();
            String query = "SELECT * FROM usuarios WHERE usuario='"+nombre+"'";

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                salida=rs.getString("id_user");
            }


        }catch (Exception e){
            System.out.println(e);
        }

        return salida;
    }

    public ArrayList<String> listaComentarios(String id_elemento){
        ArrayList<String> arr = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            String query = "SELECT * FROM comentario WHERE id_elemento="+id_elemento;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                arr.add(rs.getString("contenido"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }
}
