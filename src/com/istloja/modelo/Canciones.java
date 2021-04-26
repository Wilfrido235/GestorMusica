/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author johnp
 */
public class Canciones {

    private int idCanciones;
    private String titulo;
    private String Artista;
    private String Grupo;
    private String Album;
    private Date Publicacion;
    private String genero;
    private String Duracion;
    private Date FechaRegistro;

    public Canciones(int idCanciones, String titulo, String Artista, String Grupo, String Album, Date Publicacion, String genero, String Duracion, Date FechaRegistro) {
        this.idCanciones = idCanciones;
        this.titulo = titulo;
        this.Artista = Artista;
        this.Grupo = Grupo;
        this.Album = Album;
        this.Publicacion = Publicacion;
        this.genero = genero;
        this.Duracion = Duracion;
        this.FechaRegistro = FechaRegistro;
    }

    public Canciones() {

    }

    public int getIdCanciones() {
        return idCanciones;
    }

    public void setIdCanciones(int idCanciones) {
        this.idCanciones = idCanciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String Album) {
        this.Album = Album;
    }

    public Date getPublicacion() {
        return Publicacion;
    }

    public void setPublicacion(Date Publicacion) {
        this.Publicacion = Publicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    @Override
    public String toString() {
        return "Canciones{" + "idCanciones=" + idCanciones + ", titulo=" + titulo + ", Artista=" + Artista + ", Grupo=" + Grupo + ", Album=" + Album + ", Publicacion=" + Publicacion + ", genero=" + genero + ", Duracion=" + Duracion + ", fecha_registro=" + FechaRegistro + '}';
    }

}
