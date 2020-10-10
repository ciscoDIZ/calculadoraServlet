package controlador;

import modelo.dao.OperacionDAO;

public class Suma extends Operacion {
	OperacionDAO dao;
	public Suma(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA + operandoB, '+');
		dao = new OperacionDAO(null, operandoA, operandoB, operandoA+operandoB, '+');
		dao.insert();
	}
}
