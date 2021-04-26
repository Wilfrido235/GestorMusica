/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelTables;

import com.istloja.modelo.Discografica;
import com.istloja.vistas.GestionMusica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JIMENEZ
 */
public class ModelTableDiscografica extends AbstractTableModel {
    
    private String[] m_colNames = {"Nombre","Formato","Plataforma","TipoCompañia","Copyright","Fecha de registro"};
    private List<Discografica> discografica;
    private GestionMusica gContable;
    
    public ModelTableDiscografica(List<Discografica> discografica,GestionMusica gContable) {
        this.discografica= discografica;
        this.gContable = gContable;
    }
    @Override
    public int getRowCount() {
        return discografica.size();
    }
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Discografica disco = discografica.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return disco.getNombre();
            case 1:
                return disco.getFormato();
            case 2:
                return disco.getPlataforma();
            case 3:
                return disco.getTipoCompañia();
            case 4:
                return disco.getCopyright();
            case 5:
                return disco.getFecha_registro();
        }
        return new String();
    }
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickDiscografica(discografica.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Discografica> getDiscografica() {
        return discografica;
    }
    public void setDiscografica(List<Discografica> discogrfica) {
        this.discografica= discogrfica;
    }
    
}
