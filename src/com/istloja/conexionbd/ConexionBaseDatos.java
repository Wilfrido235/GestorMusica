package com.istloja.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBaseDatos {

    private Connection conexion;
    //declaramos los datos de conexion
    private static final String user = "root";
    private static final String pass = "dj1234,.-";
    private static final String url = "jdbc:mysql://localhost:4550/gestionmusica? useUnicode=true&use"
            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection conexionbd() {
        conexion = null;
        try {
//             
            conexion = (Connection) DriverManager.getConnection(url, user, pass);

            if (conexion != null) {
                System.out.println("Conexion exitosa");
            }

        } catch (Exception e) {
            System.out.println("Error de conexion" + e.getMessage());
        }
        return conexion;
    }
}
