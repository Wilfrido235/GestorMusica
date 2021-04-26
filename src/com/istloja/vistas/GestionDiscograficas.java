/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istloja.modelo.Discografica;
import com.istloja.utilidad.Utilidades;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danielmora
 */
public class GestionDiscograficas {

    private JTextField txtNombreDiscografica;
    private JComboBox  jComboFormatoDiscografica;
    private JComboBox  jComboPlataformaDiscografica;
    private JComboBox  jComboTipoCompañiaDiscografica;
    private JComboBox  jComboCopyDiscografica;
    private Utilidades utilidades;
    private JFrame frameGestionContable;
    private JDateChooser jDateFechaDiscografica;

    public GestionDiscograficas(JTextField txtNombreDiscografica, JComboBox jComboFormatoDiscografica, JComboBox jComboPlataformaDiscografica, JComboBox jComboTipoCompañiaDiscografica, JComboBox jComboCopyDiscografica, Utilidades utilidades, JFrame frameGestionContable, JDateChooser jDateFechaDiscografica) {
        this.txtNombreDiscografica = txtNombreDiscografica;
        this.jComboFormatoDiscografica = jComboFormatoDiscografica;
        this.jComboPlataformaDiscografica = jComboPlataformaDiscografica;
        this.jComboTipoCompañiaDiscografica = jComboTipoCompañiaDiscografica;
        this.jComboCopyDiscografica = jComboCopyDiscografica;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
        this.jDateFechaDiscografica = jDateFechaDiscografica;
    }

    public JTextField getTxtNombreDiscografica() {
        return txtNombreDiscografica;
    }

    public void setTxtNombreDiscografica(JTextField txtNombreDiscografica) {
        this.txtNombreDiscografica = txtNombreDiscografica;
    }

    public JComboBox getjComboFormatoDiscografica() {
        return jComboFormatoDiscografica;
    }

    public void setjComboFormatoDiscografica(JComboBox jComboFormatoDiscografica) {
        this.jComboFormatoDiscografica = jComboFormatoDiscografica;
    }

    public JComboBox getjComboPlataformaDiscografica() {
        return jComboPlataformaDiscografica;
    }

    public void setjComboPlataformaDiscografica(JComboBox jComboPlataformaDiscografica) {
        this.jComboPlataformaDiscografica = jComboPlataformaDiscografica;
    }

    public JComboBox getjComboTipoCompañiaDiscografica() {
        return jComboTipoCompañiaDiscografica;
    }

    public void setjComboTipoCompañiaDiscografica(JComboBox jComboTipoCompañiaDiscografica) {
        this.jComboTipoCompañiaDiscografica = jComboTipoCompañiaDiscografica;
    }

    public JComboBox getjComboCopyDiscografica() {
        return jComboCopyDiscografica;
    }

    public void setjComboCopyDiscografica(JComboBox jComboCopyDiscografica) {
        this.jComboCopyDiscografica = jComboCopyDiscografica;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameGestionContable() {
        return frameGestionContable;
    }

    public void setFrameGestionContable(JFrame frameGestionContable) {
        this.frameGestionContable = frameGestionContable;
    }

    public JDateChooser getjDateFechaDiscografica() {
        return jDateFechaDiscografica;
    }

    public void setjDateFechaDiscografica(JDateChooser jDateFechaDiscografica) {
        this.jDateFechaDiscografica = jDateFechaDiscografica;
    }


    public void limpiarDiscografia() {
        txtNombreDiscografica.setText("");
        jComboFormatoDiscografica.setSelectedIndex(0);
        jComboPlataformaDiscografica.setSelectedIndex(0);
        jComboTipoCompañiaDiscografica.setSelectedIndex(0);
        jComboCopyDiscografica.setSelectedIndex(0);
        jDateFechaDiscografica.setCalendar(null);
    }

    public Discografica guardarEditarDiscografias(boolean isEditar) {

        if (txtNombreDiscografica.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Nombre no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombreDiscografica.requestFocus();
            return null;
         }if (jDateFechaDiscografica.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo dFecha de registro no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
              jDateFechaDiscografica.requestFocus();
             return null;
         }
        Discografica disco = new Discografica();
        disco.setNombre(txtNombreDiscografica.getText());
        disco.setPlataforma(jComboFormatoDiscografica.getSelectedIndex());
        disco.setFormato(jComboPlataformaDiscografica.getSelectedIndex());
        disco.setTipoCompañia(jComboTipoCompañiaDiscografica.getSelectedIndex());
        disco.setCopyright(jComboCopyDiscografica.getSelectedIndex());
        disco.setFecha_registro(jDateFechaDiscografica.getDate());
        
        return disco;
    }

}
