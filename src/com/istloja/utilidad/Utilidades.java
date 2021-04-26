/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istloja.utilidad;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author johnp
 */
public class Utilidades {

    
    public boolean validarNumeros(String numero){
        //Coleccion caracteres
        if (numero.charAt(0)!='0') {
            return false;
        }
        if (numero.isEmpty()) {
            return false;
        }else if (numero.length()<10) {
            return false;
        }
        try {
            int validarNumero=Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String devolverFecha(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(fecha);
    }
     public double dosDecimales(double entrada){
        return Math.round(entrada*100.0)/100.0;
    } 
}
