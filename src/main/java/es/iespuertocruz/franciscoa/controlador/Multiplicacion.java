package es.iespuertocruz.franciscoa.controlador;

public class Multiplicacion extends Operacion {
	public Multiplicacion(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA * operandoB, '*');
	}
	
}
