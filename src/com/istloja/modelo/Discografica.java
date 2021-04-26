/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.modelo;

import java.util.Date;

/**
 *
 * @author JIMENEZ
 */
public class Discografica {

    private int idDiscografica;
    private String Nombre;
    private int Formato;
    private int Plataforma;
    private int TipoCompañia;
    private int Copyright;
    private Date fecha_registro;
    
    
    private int cantidadProductosVender;


    public Discografica() {
    }

    public Discografica(int idDiscografica, String Nombre, int Formato, int Plataforma, int TipoCompañia, int Copyright, Date fecha_registro, int cantidadProductosVender) {
        this.idDiscografica = idDiscografica;
        this.Nombre = Nombre;
        this.Formato = Formato;
        this.Plataforma = Plataforma;
        this.TipoCompañia = TipoCompañia;
        this.Copyright = Copyright;
        this.fecha_registro = fecha_registro;
        this.cantidadProductosVender = cantidadProductosVender;
    }

    public int getIdDiscografica() {
        return idDiscografica;
    }

    public void setIdDiscografica(int idDiscografica) {
        this.idDiscografica = idDiscografica;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getFormato() {
        return Formato;
    }

    public void setFormato(int Formato) {
        this.Formato = Formato;
    }

    public int getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(int Plataforma) {
        this.Plataforma = Plataforma;
    }

    public int getTipoCompañia() {
        return TipoCompañia;
    }

    public void setTipoCompañia(int TipoCompañia) {
        this.TipoCompañia = TipoCompañia;
    }

    public int getCopyright() {
        return Copyright;
    }

    public void setCopyright(int Copyright) {
        this.Copyright = Copyright;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCantidadProductosVender() {
        return cantidadProductosVender;
    }

    public void setCantidadProductosVender(int cantidadProductosVender) {
        this.cantidadProductosVender = cantidadProductosVender;
    }

    @Override
    public String toString() {
        return "Discografica{" + "idDiscografica=" + idDiscografica + ", Nombre=" + Nombre + ", Formato=" + Formato + ", Plataforma=" + Plataforma + ", TipoCompa\u00f1ia=" + TipoCompañia + ", Copyright=" + Copyright + ", fecha_registro=" + fecha_registro + ", cantidadProductosVender=" + cantidadProductosVender + '}';
    }
    
}
