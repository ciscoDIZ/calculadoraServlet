package controlador;

import modelo.dao.OperacionDAO;

/**
 * 
 * @author tote
 *
 */
public class Division extends Operacion {
	private OperacionDAO dao;

	public Division(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA/operandoB, '/');
		dao = new OperacionDAO(null, operandoA, operandoB, operandoA/operandoB, '/');
		dao.insert();
	}
	
}
