package controlador;

import modelo.dao.OperacionDAO;

/**
 * 
 * @author tote
 *
 */
public class Division extends Operacion {
	public Division(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA/operandoB, '/');
	}
	
}
