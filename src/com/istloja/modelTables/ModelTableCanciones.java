/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.Canciones;
import com.istloja.vistas.GestionMusica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JIMENEZ
 */
public class ModelTableCanciones extends AbstractTableModel {
    
    private String[] m_colNames = {"TITULO", "ARTISTA", "GRUPO", "ALBUM", "PUBLICACION","GENERO","DURACION","FECHA REGISTRO"};
    private List<Canciones> canciones;
    private GestionMusica gContable;
    
    public ModelTableCanciones(List<Canciones> canciones,GestionMusica gContable) {
        this.canciones= canciones;
        this.gContable = gContable;
    }
    @Override
    public int getRowCount() {
        return canciones.size();
    }
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Canciones cancion = canciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cancion.getTitulo();
            case 1:
                return cancion.getArtista();
            case 2:
                return cancion.getGrupo();
            case 3:
                return cancion.getAlbum();
            case 4:
                return cancion.getPublicacion();
            case 5:
                return cancion.getGenero();
            case 6:
                return cancion.getDuracion();
            case 7:
                return cancion.getFechaRegistro();
          
        }
        return new String();
    }
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickCanciones(canciones.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Canciones> getInventarios() {
        return canciones;
    }
    public void setCanciones(List<Canciones> canciones) {
        this.canciones = canciones;
    }
    
}
