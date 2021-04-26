/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.controlador;

import com.istloja.conexionbd.ConexionBaseDatos;
import com.istloja.modelo.PlaylistAgregado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIMENEZ
 */
public class PlaylistAgregadobd {
    public boolean registrarPlaylistAgregado(PlaylistAgregado playListAgregado) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
        sql = "INSERT INTO `gestionmusica`.`musicaagregada` (`NombrePlaylist`, `TituloCancion`, `ArtistaPlaylist`, `AlbumPlaylist`, `GeneroPlaylist`, `DuracionPlaylist`, `NombreDiscograficaPlaylist`, `CopyPlaylist`) VALUES "
                + "('" + playListAgregado.getNombrePlaylist() + "',"
                + " '" + playListAgregado.getTituloCancion() + "', "
                + "'" + playListAgregado.getArtistaPlaylist() + "',"
                + " '" + playListAgregado.getAlbumPlaylist() + "',"
                + " '" + playListAgregado.getGeneroPlaylist() + "', "
                + "'" + playListAgregado.getDuracionPlaylist() + "',"
                + " '" + playListAgregado.getNombreDiscograficaPlaylist()+"',"
                + " '" + playListAgregado.getCopyPlaylist() +"');";
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
 public List<PlaylistAgregado> obtenerPlaylistAgregado() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM gestionmusica.musicaagregada;";
        List<PlaylistAgregado> listaPlaylistAgregado = new ArrayList<PlaylistAgregado>();
        try {
            co = new ConexionBaseDatos().conexionbd();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                PlaylistAgregado c = new PlaylistAgregado();
                c.setIdMusicaAgregada(rs.getInt(1));
                c.setTituloCancion(rs.getString(2));
                c.setArtistaPlaylist(rs.getString(3));
                c.setAlbumPlaylist(rs.getString(4));
                c.setGeneroPlaylist(rs.getString(5));
                c.setDuracionPlaylist(rs.getString(6));
                c.setNombreDiscograficaPlaylist(rs.getString(7));
                c.setCopyPlaylist(rs.getString(8));
                listaPlaylistAgregado.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaPlaylistAgregado;
    }
}
