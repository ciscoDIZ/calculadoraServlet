package controlador;

import modelo.dao.OperacionDAO;

public class Multiplicacion extends Operacion {
	private OperacionDAO dao;
	public Multiplicacion(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA * operandoB, '*');
		dao = new OperacionDAO(null,operandoA,operandoB,operandoA*operandoB,'*');
		dao.insert();
	}
	
}
