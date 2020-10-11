/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertocruz.franciscoa.modelo;

/**
 *
 * @author tote
 */
public class Operacion {
    protected Integer id;
    protected Double operandoA;
    protected Double operandoB;
    protected Double resultado;
    protected char operador;

    public Operacion(Integer id, Double operandoA, Double operandoB, Double resultado, char operador) {
        this.id = id;
        this.operandoA = operandoA;
        this.operandoB = operandoB;
        this.resultado = resultado;
        this.operador = operador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getOperandoA() {
        return operandoA;
    }

    public void setOperandoA(Double operador) {
        this.operandoA = operador;
    }

	public Double getOperandoB() {
		return operandoB;
	}

	public void setOperandoB(Double operandoB) {
		this.operandoB = operandoB;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	public char getOperador() {
		return operador;
	}

	public void setOperador(char operador) {
		this.operador = operador;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}
