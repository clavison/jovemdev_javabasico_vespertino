package br.com.trier.aula_2.imc;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pessoa {
	
	String nome;
	char sexo;
	double peso;
	double altura;
	
	double calculaImc() {
		return peso / (altura * altura);
	}
	
	void cadastrar() {
		nome = JOptionPane.showInputDialog("Nome");
		sexo = JOptionPane.showInputDialog("Sexo").toUpperCase().charAt(0);
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
	}
	
	String formataValor(double vl) {
		DecimalFormat df = new DecimalFormat("###,###.00");
		return df.format(vl);
	}
	
	String imprimir() {
		return "Nome:" + nome + " IMC: "+ formataValor(calculaImc()) + "(" + avaliaImc()+")\n";
	}
	
	String avaliaImc() {
		String ret = "Não identificado";
		double imc = calculaImc();
		
		if(sexo == 'F') {
			imc = imc * 0.9;
		}
		
		if(imc <= 18.5 ) {
			ret = "Abaixo do peso";
		}else {
			if(imc > 18.5 && imc <= 25) {
				ret = "Peso ideal";
			}else {
				if(imc > 25 && imc <= 30) {
					ret = "Sobrepeso";
				}else {
					ret = "Obesidade";
				}
			}
		}
		return ret;
	}

}
