package es.iespuertocruz.franciscoa.controlador;


public class Suma extends Operacion {
	public Suma(Double operandoA, Double operandoB) {
		super(operandoA, operandoB, operandoA + operandoB, '+');
	}
}
