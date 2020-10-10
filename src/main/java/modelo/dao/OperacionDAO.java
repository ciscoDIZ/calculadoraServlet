/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.Operacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author tote
 */
public class OperacionDAO extends Operacion implements DAO{
    public OperacionDAO(Integer id, Double operandoA, Double operandoB, Double resultado, char operador) {
        super(id,operandoA,operandoB,resultado,operador);
    }
    
    private static Connection conectar() throws Exception{
        ConexionMySQL conexionMySQL = ConexionMySQL.getConexion();
        return conexionMySQL.getConn();
    }
    @Override
    public Object get() {
        try{
            Connection connection = conectar();
            String query = "select * from "+ ConexionMySQL.TOPERACIONES+" where " +
                    ConexionMySQL.TOPERACIONES_ID_OPERACION+" = "+id;
            try(Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                if(resultSet.next()){
                    setId(resultSet.getInt(0));
                    setOperandoA(resultSet.getDouble(1));
                    setOperandoB(resultSet.getDouble(2));
                    setResultado(resultSet.getDouble(3));
                    setOperador(resultSet.getString(4).charAt(0));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return this;
    }

    @Override
    public void insert() {
        try{
            Connection connection = conectar();
            String query = "insert into "+ ConexionMySQL.TOPERACIONES+"("+
                    ConexionMySQL.TOPERACIONES_OPERANDO_A+", "+ ConexionMySQL.TOPERACIONES_OPERANDO_B+
                    ", "+ ConexionMySQL.TOPERACIONES_RESULTADO+", "+ ConexionMySQL.TOPERACIONES_OPERADOR+") values (?,?,?,?);";
            try(PreparedStatement ps = connection.prepareStatement(query)){
                ps.setDouble(1, operandoA);
                ps.setDouble(2, operandoB);
                ps.setDouble(3, resultado);
                ps.setString(4, String.valueOf(operador));
                ps.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete() {
        try {
            Connection connection = conectar();
            String query = "delete from "+ ConexionMySQL.TOPERACIONES+" where "+
                    ConexionMySQL.TOPERACIONES_ID_OPERACION+"="+id;
            try(PreparedStatement ps = connection.prepareStatement(query)){
                ps.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<OperacionDAO> getResultados(){
        ArrayList<OperacionDAO> resultados = new ArrayList<>();
        try{
            Connection connection = conectar();
            String query = "select * from "+ ConexionMySQL.TOPERACIONES;
            try(Statement s = connection.createStatement()){
                ResultSet resultSet = s.executeQuery(query);
                while(resultSet.next()){
                    resultados.add(new OperacionDAO(resultSet.getInt(1),
                    		resultSet.getDouble(2), resultSet.getDouble(3),
                    		resultSet.getDouble(4), resultSet.getString(5).charAt(0)));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return resultados;
    }

	@Override
	public String toString() {
		return operandoA+" "+operador+" "+operandoB+" = "+resultado;
	}
    
    
}
