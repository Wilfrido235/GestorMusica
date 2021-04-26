/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.vistas;

import com.istloja.modelo.PlaylistAgregado;
import com.istloja.utilidad.Utilidades;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author johnp
 */
public class GestionPlaylistAgregado {

    private JTextField txtNombrePlaylist;
    private JTextField txtTituloCancion;
    private JTextField txtArtistaPlaylist;
    private JTextField txtAlbumPlaylist;
    private JTextField txtGeneroPlaylist;
    private JTextField txtDuracionPlaylist;
    private Utilidades utilidades;
    private JFrame frameGestionContable;
    private JTextField txtNombreDiscograficaPlaylist;
    private JTextField txtCopyPlaylist;

    public GestionPlaylistAgregado(JTextField txtNombrePlaylist, JTextField txtTituloCancion, JTextField txtArtistaPlaylist, JTextField txtAlbumPlaylist, JTextField txtGeneroPlaylist, JTextField txtDuracionPlaylist, Utilidades utilidades, JFrame frameGestionContable, JTextField txtNombreDiscograficaPlaylist, JTextField txtCopyPlaylist) {
        this.txtNombrePlaylist = txtNombrePlaylist;
        this.txtTituloCancion = txtTituloCancion;
        this.txtArtistaPlaylist = txtArtistaPlaylist;
        this.txtAlbumPlaylist = txtAlbumPlaylist;
        this.txtGeneroPlaylist = txtGeneroPlaylist;
        this.txtDuracionPlaylist = txtDuracionPlaylist;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
        this.txtNombreDiscograficaPlaylist = txtNombreDiscograficaPlaylist;
        this.txtCopyPlaylist = txtCopyPlaylist;
    }

    public JTextField getTxtNombrePlaylist() {
        return txtNombrePlaylist;
    }

    public void setTxtNombrePlaylist(JTextField txtNombrePlaylist) {
        this.txtNombrePlaylist = txtNombrePlaylist;
    }

    public JTextField getTxtTituloCancion() {
        return txtTituloCancion;
    }

    public void setTxtTituloCancion(JTextField txtTituloCancion) {
        this.txtTituloCancion = txtTituloCancion;
    }

    public JTextField getTxtArtistaPlaylist() {
        return txtArtistaPlaylist;
    }

    public void setTxtArtistaPlaylist(JTextField txtArtistaPlaylist) {
        this.txtArtistaPlaylist = txtArtistaPlaylist;
    }

    public JTextField getTxtAlbumPlaylist() {
        return txtAlbumPlaylist;
    }

    public void setTxtAlbumPlaylist(JTextField txtAlbumPlaylist) {
        this.txtAlbumPlaylist = txtAlbumPlaylist;
    }

    public JTextField getTxtGeneroPlaylist() {
        return txtGeneroPlaylist;
    }

    public void setTxtGeneroPlaylist(JTextField txtGeneroPlaylist) {
        this.txtGeneroPlaylist = txtGeneroPlaylist;
    }

    public JTextField getTxtDuracionPlaylist() {
        return txtDuracionPlaylist;
    }

    public void setTxtDuracionPlaylist(JTextField txtDuracionPlaylist) {
        this.txtDuracionPlaylist = txtDuracionPlaylist;
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

    public JTextField getTxtNombreDiscograficaPlaylist() {
        return txtNombreDiscograficaPlaylist;
    }

    public void setTxtNombreDiscograficaPlaylist(JTextField txtNombreDiscograficaPlaylist) {
        this.txtNombreDiscograficaPlaylist = txtNombreDiscograficaPlaylist;
    }

    public JTextField getTxtCopyPlaylist() {
        return txtCopyPlaylist;
    }

    public void setTxtCopyPlaylist(JTextField txtCopyPlaylist) {
        this.txtCopyPlaylist = txtCopyPlaylist;
    }


    public void limpiarCamposPlaylistAgregado() {
        txtNombrePlaylist.setText("");
        txtTituloCancion.setText("");
        txtArtistaPlaylist.setText("");
        txtAlbumPlaylist.setText("");
        txtGeneroPlaylist.setText("");
        txtDuracionPlaylist.setText("");
        txtNombreDiscograficaPlaylist.setText("");
        txtCopyPlaylist.setText("");
        txtNombrePlaylist.requestFocus();
      
        
    }

    public PlaylistAgregado guardarPlaylistAgregado(boolean isEditar) {
        if (txtNombrePlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Titulo no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombrePlaylist.requestFocus();// Sirve para ubicar el cursor en un campo vacio.
            return null;
        }
        if (txtTituloCancion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Artista no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTituloCancion.requestFocus();
            return null;
        }
        if (txtArtistaPlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Grupo no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtArtistaPlaylist.requestFocus();
            return null;
        }
        if (txtAlbumPlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Album no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtAlbumPlaylist.requestFocus();
            return null;
        }
        if (txtGeneroPlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Genero no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtGeneroPlaylist.requestFocus();
            return null;
        }
        if (txtDuracionPlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo duracion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtDuracionPlaylist.requestFocus();
            return null;
        }
        if (txtNombreDiscograficaPlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo duracion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombreDiscograficaPlaylist.requestFocus();
            return null;
        }if (txtCopyPlaylist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo duracion no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtCopyPlaylist.requestFocus();
            return null;
        }
        PlaylistAgregado playlist = new PlaylistAgregado();
        playlist.setNombrePlaylist(txtNombrePlaylist.getText());
        playlist.setTituloCancion(txtTituloCancion.getText());
        playlist.setArtistaPlaylist(txtArtistaPlaylist.getText());
        playlist.setAlbumPlaylist(txtAlbumPlaylist.getText());
        playlist.setGeneroPlaylist(txtGeneroPlaylist.getText());
        playlist.setDuracionPlaylist(txtDuracionPlaylist.getText());
        playlist.setNombreDiscograficaPlaylist(txtNombreDiscograficaPlaylist.getText());
        playlist.setCopyPlaylist(txtCopyPlaylist.getText());
        
        return playlist;
    }

}
