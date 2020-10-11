package es.iespuertocruz.franciscoa.vista;

import es.iespuertocruz.franciscoa.controlador.Division;
import es.iespuertocruz.franciscoa.controlador.Multiplicacion;
import es.iespuertocruz.franciscoa.controlador.Resta;
import es.iespuertocruz.franciscoa.controlador.Suma;

import java.util.InputMismatchException;

public class Calculadora {

	public Calculadora() {
	}

	private Suma sumar(double opA, double opB) {
		return new Suma(opA, opB);
	}

	private Resta restar(double opA, double opB) {
		return new Resta(opA, opB);
	}

	private Multiplicacion multiplicar(double opA, double opB) {
		return new Multiplicacion(opA, opB);
	}

	private Division dividir(double opA, double opB) {
		return new Division(opA, opB);
	}

	public double operar(double opA, double opB, char operador) throws InputMismatchException {
		double resultado = 0.0;
		switch (operador) {
		case '+':
			resultado = sumar(opA, opB).getResultado();
			break;
		case '-':
			resultado = restar(opA, opB).getResultado();
			break;
		case '*':
			resultado = multiplicar(opA, opB).getResultado();
			break;
		case '/':
			resultado = dividir(opA, opB).getResultado();
			break;
		default:
			
			break;
		}
		return resultado;
	}
}
