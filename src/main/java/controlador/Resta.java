package controlador;

import modelo.dao.OperacionDAO;

public class Resta extends Operacion {
	OperacionDAO dao;
	public Resta(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA - operandoB, '-');
		dao = new OperacionDAO(null, operandoA, operandoB, operandoA-operandoB, '-');
		dao.insert();
	}
}
