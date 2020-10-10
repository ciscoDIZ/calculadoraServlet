package controlador;

import modelo.dao.OperacionDAO;

public class Multiplicacion extends Operacion {
	public Multiplicacion(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA * operandoB, '*');
	}
	
}
