package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {

    private Connection conexion;
    private Properties mispropiedades;

    public BaseDatos() {
        mispropiedades = new Properties();
        conexion = null;
        try {
            mispropiedades.load(new FileReader("data/config.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void EstableciendoConexion() {
        String db = mispropiedades.getProperty("database");
        System.out.println(db);
        String iploc = mispropiedades.getProperty("IPLocal");
        String user = mispropiedades.getProperty("usuario");
        String pass = mispropiedades.getProperty("pass");
        String url = "jdbc:mysql://" + iploc + ":3306/" + db;

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion creada con exito");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error en establecer conexion");
        }
    }

    public void closeConnection() {
        try {
            conexion.close();
            System.out.println("Conexion cerrada con exito");
        } catch (SQLException e) {
            System.out.println("Problema al cerrar la conexion de la Base de Datos");
        }
    }

    public ResultSet Vertodos() {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "SELECT * FROM ferreteria";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Problema Buscando La Base de Dtos");
        }
        return rs;
    }
    
    public ResultSet consultarID(int id) {
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "SELECT * FROM ferreteria WHERE referencia = ? ";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Problema Buscando La Base de Datos");
        }

        return rs;
    }

    public String InsertarRegistro(int id, String Nombre, String Categoria, int valorCompra, int valorVenta, int cantidadProducto) {
        PreparedStatement ps;
        String sql = "INSERT INTO ferreteria (referencia, nombre, categoria, valorCompra, valorVenta, cantidadProducto) VALUES (?,?, ?, ?, ?, ?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, Nombre);
            ps.setString(3, Categoria);
            ps.setInt(4, valorCompra);
            ps.setInt(5, valorVenta);
            ps.setInt(6, cantidadProducto);
            int contador = ps.executeUpdate();
            if (contador > 0) {
                return "Se agregó el registro de manera exitosa";
            } else {
                return "Ocurrio un problema al agregar el registro";

            }
        } catch (SQLException e) {
            return "Problema al insertar la información";
        }

    }
    
    //Metodo para borrar registros
    public void borrarRegistro(int id){
        try{
            String Query = "DElETE FROM ferreteria WHERE referencia = " + id + ";";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            if(st.getUpdateCount() == 1){
                System.out.println("Dato Eliminado");
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    //Por medio de la columna y el codigo retorna el dato a consultar de la base de datos en forma de String
    public String getDato(int id, String columna){
        String dato = "";
        try{
            String Query = "SELECT * FROM ferreteria WHERE referencia = " + id + ";";
            Statement st = conexion.createStatement();
            ResultSet rS;
            rS = st.executeQuery(Query);
            rS.next();
            dato = rS.getString(columna);
        }catch (SQLException ex){
            System.out.println(ex);
        }
        return dato;
    }  
    //Metodo para actualizar campos de texto
    public void setDato(int id, String columna, String dato){
        try{
            String Query = "UPDATE ferreteria SET " +columna  + " = " + "'" + dato + "'" + " WHERE referencia =  " + id + ";";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            if(st.getUpdateCount() == 1){
                System.out.println("Dato actualizado");
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }
    //Metodo para actualizar campos de valores numericos
    public void setDatoV2(int id, String columna, int dato){
        try{
            String Query = "UPDATE ferreteria SET " +columna  + " = " + dato + " WHERE referencia =  " + id + ";";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            if(st.getUpdateCount() == 1){
                System.out.println("Dato actualizado");
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

}
