/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author martín y pablo
 */
public class Conexiones {

    private Connection conexion;
    // Adaptalos a tu conexion
    String host ;
    String baseDatos;
    String usuario ;
    String password ;
    /**
     * Es el constructor de la clase Conexiones
     * @throws SQLException 
     */
    public Conexiones() throws SQLException {
        // Adaptalos a tu conexion
         host = "localhost";
         baseDatos = "championsimulator";
         usuario = "root";
         password = "";

        // Cadena de conexion para conectarnos a la base de datos en MySQL
        String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos;

        // Creo la conexion 
        conexion = DriverManager.getConnection(cadenaConexion, usuario, password);

        // Hace commit automaticamente
        conexion.setAutoCommit(true);

    }

    /**
     * Este metodo sirve para la ejecucion de una consulta a la base de datos
     *
     * @param SQL Consulta a ejecutar
     * @return ResultSet con los datos de la consulta
     * @throws SQLException
     */
    public ResultSet ejecutarConsulta(String SQL) throws SQLException {
        Statement statement = this.conexion.createStatement();
        return statement.executeQuery(SQL);
    }

    /**
     * Este metodo sirve para la ejecucion de una funcionalidad sin ser una consulta a la base de datos
     *
     * @param SQL Instrucción a ejecutar
     * @return numero de filas afectadas
     * @throws SQLException
     */
    public int ejecutarInstruccion(String SQL) throws SQLException {
        Statement statement = this.conexion.createStatement();
        return statement.executeUpdate(SQL);
    }

    /**
     * Este metodo sirve para cerrar la conexion a la base de datos
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        this.conexion.close();
    }

}
