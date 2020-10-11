package es.iespuertocruz.franciscoa.controlador;

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
