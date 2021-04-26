/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.modelo.Discografica;
import com.istloja.utilidad.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Discografiabd {
    Utilidades utilidades;

    public Discografiabd() {
        utilidades = new Utilidades();
    }
     public boolean registrarDiscografia(Discografica Discografia) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String   sql = "INSERT INTO `gestionmusica`.`discografica` (`idDiscografica`, `Nombre`, `Formato`, `Plataforma`, `TipoCompañia`, `Copyright`, `FechaRegistro`) VALUES  ('"
                +Discografia.getIdDiscografica()+"','"
                +Discografia.getNombre()+"', '"
                +Discografia.getFormato()+"','"
                +Discografia.getPlataforma()+"','"
                +Discografia.getTipoCompañia()+"','"
                +Discografia.getCopyright()+"','"
                + utilidades.devolverFecha(Discografia.getFecha_registro()) + "');";
        try {
            //Es una instancia de la conexion previamente creada.
            ConexionBaseDatos conexion = new ConexionBaseDatos();
            con = conexion.conexionbd();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    } 
     public boolean actualizarDiscografica(Discografica discografica) {
         System.out.println("Actualizar:"+ discografica);
        // ConexionBaseDatos con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `gestionmusica`.`discografica` SET `"
                + "Nombre` = '" +discografica.getNombre()+"',`"
                + "Formato` = '" +discografica.getFormato()+"',`"
                + "Plataforma` = '" +discografica.getPlataforma()+"', `"
                + "TipoCompañia` = '" +discografica.getTipoCompañia()+"',`"
                + "Copyright` = '" +discografica.getCopyright()+"', `"
                + "FechaRegistro` = '" +discografica.getFecha_registro()+"'"
                +"WHERE `idDiscografica` = '" +discografica.getIdDiscografica()+"';";
        try {
            ConexionBaseDatos con = new ConexionBaseDatos();
            connect = con.conexionbd();
            //Puente entre la conexion y el codigo
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return actualizar;
    }
      public boolean eliminarDiscografica(Discografica discografia) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `gestionmusica`.`discografica` WHERE (`idDiscografica` = '"+discografia.getIdDiscografica()+"');";
        try {
            connect = new ConexionBaseDatos().conexionbd();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
       public List<Discografica> obtenerDiscografias() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM gestionmusica.discografica;";
        List<Discografica> listaDiscografia = new ArrayList<Discografica>();
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Discografica c = new Discografica();
                c.setIdDiscografica(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setFormato(rs.getInt(3));
                c.setPlataforma(rs.getInt(4));
                c.setTipoCompañia(rs.getInt(5));
                c.setCopyright(rs.getInt(6));
                c.setFecha_registro(rs.getDate(7));
                listaDiscografia.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaDiscografia;
    }
     public List<Discografica> getNombreDiscografiaListo(String Nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Discografica> listaDiscografia = new ArrayList<>();
        String sql = "SELECT * FROM gestionmusica.discografica where Nombre like \"%"+Nombre+"%\"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Discografica c = new Discografica();
                c.setIdDiscografica(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setFormato(rs.getInt(3));
                c.setPlataforma(rs.getInt(4));
                c.setTipoCompañia(rs.getInt(5));
                c.setCopyright(rs.getInt(6));
                c.setFecha_registro(rs.getDate(7));
                listaDiscografia.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return listaDiscografia;
    }
   
 public Discografica getNombreDiscografia(String Nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Discografica c = null;
        String sql = "SELECT * FROM gestionmusica.discografica where Nombre like '%" + Nombre + "%';";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Discografica();
                c.setIdDiscografica(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setFormato(rs.getInt(3));
                c.setPlataforma(rs.getInt(4));
                c.setTipoCompañia(rs.getInt(5));
                c.setCopyright(rs.getInt(6));
                c.setFecha_registro(rs.getDate(7));
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return c;
    }
    
}
