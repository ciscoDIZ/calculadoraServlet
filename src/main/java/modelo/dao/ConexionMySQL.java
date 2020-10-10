package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    //tablas
    public static final String TOPERACIONES = "operaciones";
    //registros tabla resultados
    public static final String TOPERACIONES_ID_OPERACION = "id_operacion";
    public static final String TOPERACIONES_OPERANDO_A = "operando_a";
    public static final String TOPERACIONES_OPERANDO_B = "operando_b";
    public static final String TOPERACIONES_RESULTADO = "resultado";
    public static final String TOPERACIONES_OPERADOR = "operador";
    //parámetros conexión
    public String jdbcUrl;
    public String usuario;
    public String contra;

    //atributos de clase;
    private Connection conn;

    private static ConexionMySQL conexion = null;

    private ConexionMySQL(String db, String usuario, String contra) throws SQLException {
        jdbcUrl = "jdbc:mysql://localhost/" + db + "?serverTimezone=UTC";
        this.usuario = usuario;
        this.contra = contra;
        cargarDriverMysql();
        mysql();
    }

    public static ConexionMySQL getConexion() throws Exception {
        if (conexion == null) {
            throw new Exception("no hay ninguna conexión creada");
        } else {
            return conexion;
        }
    }

    public static ConexionMySQL setNewConexion(String ddbb, String nombreUsuario,
                                          String password) throws SQLException {
        if (conexion != null) {
            if (conexion.getConn() != null && !conexion.getConn().isClosed()) {
                conexion.getConn().close();
            }

        }
        conexion = new ConexionMySQL(ddbb, nombreUsuario, password);
        return conexion;
    }

    public static void cargarDriverMysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("no carga el driver");
            System.exit(1);
        }
    }

    private Connection mysql() throws SQLException {
        return mysql(jdbcUrl, usuario, contra);
    }

    private Connection mysql(String url, String user, String pass) throws SQLException {
        setConn(null);
        if (url != null && !url.isEmpty()) {
            jdbcUrl = url;
        }
        if (user != null && !user.isEmpty()) {
            usuario = user;
        }
        if (pass != null && !pass.isEmpty()) {
            contra = pass;
        }
        Connection con = DriverManager.getConnection(jdbcUrl, usuario, contra);
        setConn(con);
        return getConn();
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
