/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelo;


/**
 *
 * @author JIMENEZ
 */
public class PlaylistAgregado {
    private int idMusicaAgregada;
    private String NombrePlaylist;
    private String TituloCancion;
    private String ArtistaPlaylist;
    private String AlbumPlaylist;
    private String GeneroPlaylist;
    private String DuracionPlaylist;
    private String NombreDiscograficaPlaylist;
    private String CopyPlaylist;

    public PlaylistAgregado(int idMusicaAgregada, String NombrePlaylist, String TituloCancion, String ArtistaPlaylist, String AlbumPlaylist, String GeneroPlaylist, String DuracionPlaylist, String NombreDiscograficaPlaylist, String CopyPlaylist) {
        this.idMusicaAgregada = idMusicaAgregada;
        this.NombrePlaylist = NombrePlaylist;
        this.TituloCancion = TituloCancion;
        this.ArtistaPlaylist = ArtistaPlaylist;
        this.AlbumPlaylist = AlbumPlaylist;
        this.GeneroPlaylist = GeneroPlaylist;
        this.DuracionPlaylist = DuracionPlaylist;
        this.NombreDiscograficaPlaylist = NombreDiscograficaPlaylist;
        this.CopyPlaylist = CopyPlaylist;
    }

    public PlaylistAgregado() {
        
    }

    public int getIdMusicaAgregada() {
        return idMusicaAgregada;
    }

    public void setIdMusicaAgregada(int idMusicaAgregada) {
        this.idMusicaAgregada = idMusicaAgregada;
    }

    public String getNombrePlaylist() {
        return NombrePlaylist;
    }

    public void setNombrePlaylist(String NombrePlaylist) {
        this.NombrePlaylist = NombrePlaylist;
    }

    public String getTituloCancion() {
        return TituloCancion;
    }

    public void setTituloCancion(String TituloCancion) {
        this.TituloCancion = TituloCancion;
    }

    public String getArtistaPlaylist() {
        return ArtistaPlaylist;
    }

    public void setArtistaPlaylist(String ArtistaPlaylist) {
        this.ArtistaPlaylist = ArtistaPlaylist;
    }

    public String getAlbumPlaylist() {
        return AlbumPlaylist;
    }

    public void setAlbumPlaylist(String AlbumPlaylist) {
        this.AlbumPlaylist = AlbumPlaylist;
    }

    public String getGeneroPlaylist() {
        return GeneroPlaylist;
    }

    public void setGeneroPlaylist(String GeneroPlaylist) {
        this.GeneroPlaylist = GeneroPlaylist;
    }

    public String getDuracionPlaylist() {
        return DuracionPlaylist;
    }

    public void setDuracionPlaylist(String DuracionPlaylist) {
        this.DuracionPlaylist = DuracionPlaylist;
    }

    public String getNombreDiscograficaPlaylist() {
        return NombreDiscograficaPlaylist;
    }

    public void setNombreDiscograficaPlaylist(String NombreDiscograficaPlaylist) {
        this.NombreDiscograficaPlaylist = NombreDiscograficaPlaylist;
    }

    public String getCopyPlaylist() {
        return CopyPlaylist;
    }

    public void setCopyPlaylist(String CopyPlaylist) {
        this.CopyPlaylist = CopyPlaylist;
    }

    @Override
    public String toString() {
        return "PlaylistAgregado{" + "idMusicaAgregada=" + idMusicaAgregada + ", NombrePlaylist=" + NombrePlaylist + ", TituloCancion=" + TituloCancion + ", ArtistaPlaylist=" + ArtistaPlaylist + ", AlbumPlaylist=" + AlbumPlaylist + ", GeneroPlaylist=" + GeneroPlaylist + ", DuracionPlaylist=" + DuracionPlaylist + ", NombreDiscograficaPlaylist=" + NombreDiscograficaPlaylist + ", CopyPlaylist=" + CopyPlaylist + '}';
    }
    
}
