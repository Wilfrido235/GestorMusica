/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istloja.modelo.Canciones;
import java.sql.Connection;
import java.sql.Statement;
import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.utilidad.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johnp
 */
// Gestión entre la base de datos y el modelo que se tiene implementado en java.
public class Cancionesbd {
    
    public Utilidades utilidades;

    public Cancionesbd() {
        utilidades = new Utilidades();
    }
    
    // Registrar persona en la base de datos.
    public boolean registrarCancion(Canciones canciones) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql = "INSERT INTO `gestionmusica`.`canciones` (`titulo`, `Artista`,`Grupo`,`Album`, `Publicacion`, `Genero`, `Duracion`, `FechaRegistro`) VALUES ('" 
                + canciones.getTitulo() + "','" 
                + canciones.getArtista() + "','" 
                + canciones.getGrupo() + "','" 
                + canciones.getAlbum() + "','" 
                + utilidades.devolverFecha(canciones.getPublicacion()) + "','" 
                + canciones.getGenero() + "','" 
                + canciones.getDuracion() + "','"
                + utilidades.devolverFecha(canciones.getFechaRegistro())+"');";
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
    //ACtualizar la persona e la base de datos.
    public boolean actualizarCanciones(Canciones canciones) {
        // ConexionBaseDatos con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizarCanciones = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `gestionmusica`.`canciones` SET `"
                + "titulo` = '"+ canciones.getTitulo() + "',`"
                + "Artista` = '"+ canciones.getArtista() + "',`"
                + "Grupo` = '"+ canciones.getGrupo() + "',`"
                + "Album` = '"+ canciones.getAlbum() + "',`"
                + "Publicacion` = '"+ utilidades.devolverFecha(canciones.getPublicacion()) + "',`"
                + "Genero` = '"+ canciones.getGenero() + "',`"
                + "Duracion` = '"+ canciones.getDuracion()+"',`"
                + "FechaRegistro` = '"+ utilidades.devolverFecha(canciones.getFechaRegistro())+"'"
                +"WHERE `idCanciones` = '" + canciones.getIdCanciones() + "';";
        try {
            ConexionBaseDatos con = new ConexionBaseDatos();
            connect = con.conexionbd();
            //Puente entre la conexion y el codigo
            stm = connect.createStatement();
            stm.execute(sql);
            stm.close();
            connect.close();
             actualizarCanciones = true;
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return actualizarCanciones;
    }
    //Eliminar una persona en base al ID de la persona seleccionada de la base de datos.
    public boolean eliminarCancion(Canciones canciones) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `gestionmusica`.`canciones` WHERE (`idCanciones` = '" + String.valueOf(canciones.getIdCanciones()) + "');";
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
    //Sirve para traer todos los registros de persona de la base de datos 
    public List<Canciones> obtenerCanciones() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM gestionmusica.canciones;";
        List<Canciones> listaCanciones = new ArrayList<Canciones>();
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canciones c = new Canciones();
                c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                listaCanciones.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaCanciones;
    }
    
    //Metodo para buscar una cancion por su titulo
    public Canciones getCancionTitulo(String titulo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Canciones c = null;
        String sql = "SELECT * FROM gestionmusica.canciones where titulo = '" + titulo + "';";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
              c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
    }
     public List<Canciones> getCancionTituloListo(String titulo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Canciones> CancionesEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestionmusica.canciones where titulo like '%" + titulo + "%';";
        try {
            co = new  ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canciones c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                CancionesEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return CancionesEncontradas;
    }
public Canciones getCancionArtista(String Artista) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Canciones c = null;
        String sql = "SELECT * FROM gestionmusica.canciones where Artista like "+Artista+"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
              c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
    }
     public List<Canciones> getCancionArtistaListo(String Artista) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Canciones> CancionesEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestionmusica.canciones where Artista like '%" + Artista + "%';";
        try {
            co = new  ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canciones c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                CancionesEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return CancionesEncontradas;
    }
public Canciones getCancionGrupo(String Grupo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Canciones c = null;
        String sql = "SELECT * FROM gestionmusica.canciones where Grupo like "+Grupo+"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
              c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
    }
     public List<Canciones> getCancionGrupoListo(String Grupo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Canciones> CancionesEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestionmusica.canciones where Grupo like '%" + Grupo + "%';";
        try {
            co = new  ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canciones c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                CancionesEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return CancionesEncontradas;
    }
public Canciones getCancionAlbum(String Album) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        Canciones c = null;
        String sql = "SELECT * FROM gestionmusica.canciones where Album like "+Album+"";
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
              c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return c;
    }
     public List<Canciones> getCancionAlbumListo(String Album) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<Canciones> CancionesEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM gestionmusica.canciones where Album like '%" + Album + "%';";
        try {
            co = new  ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canciones c = new Canciones();
              c.setIdCanciones(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setArtista(rs.getString(3));
                c.setGrupo(rs.getString(4));
                c.setAlbum(rs.getString(5));
                c.setPublicacion(rs.getDate(6));
                c.setGenero(rs.getString(7));
                c.setDuracion(rs.getString(8));
                c.setFechaRegistro(rs.getDate(9));
                CancionesEncontradas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return CancionesEncontradas;
    }

}
