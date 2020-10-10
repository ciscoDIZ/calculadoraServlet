/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tote
 */
public class Conexion {
    //tablas
    public static final String TOPERACIONES = "operaciones";
    //registros tabla resultados
    public static final String TOPERACIONES_ID_OPERACION = "id_operacion";
    public static final String TOPERACIONES_OPERANDO_A = "operando_a";
    public static final String TOPERACIONES_OPERANDO_B = "operando_b";
    public static final String TOPERACIONES_RESULTADO = "resultado";
    public static final String TOPERACIONES_OPERADOR = "operador";
    //parámetros de conexion
    public String jdbcUrl;
    //atributos de clase
    private Connection connection;
    private static Conexion conexion = null;

    private Conexion(String db) throws SQLException{
        jdbcUrl = "jdbc:sqlite:"+db;
        
        cargarDriverSqlite();
        sqlite();
    }
    public static Conexion getConexion() throws Exception {
        if(conexion == null){
            throw new Exception("no se ha creado conexion");
        }else{
            return conexion;
        }
    }
    public static Conexion setNewConnection(String db) throws SQLException{
        if(conexion != null){
            if (conexion.getConnection()!= null && !conexion.getConnection()
                    .isClosed()) {
                conexion.getConnection().close();
            }
        }
        conexion = new Conexion(db);
        return conexion;
    }
    
    public static void cargarDriverSqlite(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("no conecta tronco!!");
            System.exit(1);
        }
    } 
    private Connection sqlite() throws  SQLException{
        return sqlite(jdbcUrl);
    }
    
    private Connection sqlite(String url) throws SQLException{
        setConnection(null);
        if(jdbcUrl != null && !url.isEmpty()){
            jdbcUrl = url;
        }
        Connection c = DriverManager.getConnection(jdbcUrl);
        setConnection(c);
        return getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
