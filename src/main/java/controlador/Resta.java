package controlador;


public class Resta extends Operacion {
	public Resta(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA - operandoB, '-');
	}
}
