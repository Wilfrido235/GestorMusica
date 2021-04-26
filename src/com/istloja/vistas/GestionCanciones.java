/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istloja.modelo.Canciones;
import com.istloja.utilidad.Utilidades;
import com.toedter.calendar.JDateChooser;
import java.sql.Time;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author johnp
 */
public class GestionCanciones {

    private JTextField txtTitulo;
    private JTextField txtArtista;
    private JTextField txtGrupo;
    private JTextField txtAlbum;
    private JDateChooser jDatePublicacion;
    private JTextField txtGenero;
    private JTextField textDuracion;
    private Utilidades utilidades;
    private JFrame frameGestionContable;
    private JDateChooser jDateFechaRegistro;

    public GestionCanciones(JTextField txtTitulo, JTextField txtArtista, JTextField txtGrupo, JTextField txtAlbum, JDateChooser jDatePublicacion, JTextField txtGenero, JTextField textDuracion, Utilidades utilidades, JFrame frameGestionContable, JDateChooser jDateFechaRegistro) {
        this.txtTitulo = txtTitulo;
        this.txtArtista = txtArtista;
        this.txtGrupo = txtGrupo;
        this.txtAlbum = txtAlbum;
        this.jDatePublicacion = jDatePublicacion;
        this.txtGenero = txtGenero;
        this.textDuracion = textDuracion;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
        this.jDateFechaRegistro = jDateFechaRegistro;
    }

   

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public JTextField getTxtArtista() {
        return txtArtista;
    }

    public void setTxtArtista(JTextField txtArtista) {
        this.txtArtista = txtArtista;
    }

    public JTextField getTxtGrupo() {
        return txtGrupo;
    }

    public void setTxtGrupo(JTextField txtGrupo) {
        this.txtGrupo = txtGrupo;
    }

    public JTextField getTxtAlbum() {
        return txtAlbum;
    }

    public void setTxtAlbum(JTextField txtAlbum) {
        this.txtAlbum = txtAlbum;
    }

    public JDateChooser getjDatePublicacion() {
        return jDatePublicacion;
    }

    public void setjDatePublicacion(JDateChooser jDatePublicacion) {
        this.jDatePublicacion = jDatePublicacion;
    }

    public JTextField getTxtGenero() {
        return txtGenero;
    }

    public void setTxtGenero(JTextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public JTextField getTextDuracion() {
        return textDuracion;
    }

    public void setTextDuracion(JTextField textDuracion) {
        this.textDuracion = textDuracion;
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

    public JDateChooser getjDateFechaRegistro() {
        return jDateFechaRegistro;
    }

    public void setjDateFechaRegistro(JDateChooser jDateFechaRegistro) {
        this.jDateFechaRegistro = jDateFechaRegistro;
    }
    public void limpiarCamposCanciones() {
        txtTitulo.setText("");
        txtArtista.setText("");
        txtGrupo.setText("");
        txtAlbum.setText("");
        jDatePublicacion.setCalendar(null);
        txtGenero.setText("");
        textDuracion.setText("");
        txtTitulo.requestFocus();
        jDateFechaRegistro.setCalendar(null);
      
        
    }

    public Canciones guardarEditar(boolean isEditar) {
        if (txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Titulo no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTitulo.requestFocus();// Sirve para ubicar el cursor en un campo vacio.
            return null;
        }
        if (txtArtista.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Artista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtArtista.requestFocus();
            return null;
        }
        if (txtGrupo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Grupo no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtGrupo.requestFocus();
            return null;
        }
        if (txtAlbum.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Album no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtAlbum.requestFocus();
            return null;
        }
        if (txtGenero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Genero no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtGenero.requestFocus();
            return null;
        }
        if (textDuracion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo duracion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            textDuracion.requestFocus();
            return null;
        }
        if (jDatePublicacion.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo duracion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            jDatePublicacion.requestFocus();
            return null;
        }if (jDateFechaRegistro.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo duracion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            jDateFechaRegistro.requestFocus();
            return null;
        }
        Canciones cancion = new Canciones();
        cancion.setTitulo(txtTitulo.getText());
        cancion.setArtista(txtArtista.getText());
        cancion.setGrupo(txtGrupo.getText());
        cancion.setAlbum(txtAlbum.getText());
        cancion.setGenero(txtGenero.getText());
        cancion.setDuracion(textDuracion.getText());
        cancion.setPublicacion(jDatePublicacion.getDate());
        cancion.setFechaRegistro(jDateFechaRegistro.getDate());
        
        return cancion;
    }

}
