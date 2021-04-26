/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.PlaylistAgregado;
import com.istloja.vistas.GestionMusica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JIMENEZ
 */
public class ModelTablePlaylistAgregado extends AbstractTableModel {

    private String[] m_colNames = {"Nombre", "Cancion", "Artista", "Album", "Genero", "Duracion", "Nombre Discografia", "Licencia"};
    private List<PlaylistAgregado> playlistAgregado;
    private GestionMusica gContable;

    public ModelTablePlaylistAgregado(List<PlaylistAgregado> playlistAgregado, GestionMusica gContable) {
        this.playlistAgregado = playlistAgregado;
        this.gContable = gContable;
    }

    @Override
    public int getRowCount() {
        return playlistAgregado.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PlaylistAgregado list = playlistAgregado.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return list.getNombrePlaylist();
            case 1:
                return list.getTituloCancion();
            case 2:
                return list.getArtistaPlaylist();
            case 3:
                return list.getAlbumPlaylist();
            case 4:
                return list.getGeneroPlaylist();
            case 5:
                return list.getDuracionPlaylist();
            case 6:
                return list.getNombreDiscograficaPlaylist();
            case 7:
                return list.getCopyPlaylist();
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickPlaylist(playlistAgregado.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PlaylistAgregado> getPlayListAgregado() {
        return playlistAgregado;
    }

    public void setPlayListAgregado(List<PlaylistAgregado> playlistAgregado) {
        this.playlistAgregado = playlistAgregado;
    }

}
