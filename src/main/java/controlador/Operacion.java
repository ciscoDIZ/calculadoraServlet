package controlador;

import modelo.dao.Conexion;

/**
 * Clase abstracta que contriene los atributos necesarios para a partir de ella abstraer el funcionamiento
 * de una calculadora.  
 * @author 
 *
 */
public abstract class Operacion {
	protected Double operandoA;
	protected Double operandoB;
	protected Double resultado;
	protected char operador;
	/**
	 * Clase abstracta que contriene los atributos necesarios para a partir de ella abstraer el funcionamiento
	 * de una calculadora.  
	 * @param operandoA - Double: representa el primer operando
	 * @param operandoB - Double: representa el segundo operando
	 * @param resultado - Double: representa el resultado
	 * @param operador - char: representa el operador
	 */
	public Operacion(Double operandoA, Double operandoB, Double resultado, char operador) {
		this.operandoA = operandoA;
		this.operandoB = operandoB;
		this.resultado = resultado;
		this.operador = operador;

		
	}

	public Operacion() {}
	
	public Double getOperandoA() {
		return operandoA;
	}

	public void setOperandoA(Double operandoA) {
		this.operandoA = operandoA;
	}

	public Double getOperandoB() {
		return operandoB;
	}

	public void setOperandoB(Double operandoB) {
		this.operandoB = operandoB;
	}

	public char getOperador() {
		return operador;
	}

	public void setOperador(char operador) {
		this.operador = operador;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
}
