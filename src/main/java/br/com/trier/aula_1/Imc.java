package br.com.trier.aula_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Imc {
	
	static List<String> nomes = new ArrayList<String>();
	static List<String> sexos = new ArrayList<String>();
	static List<Double> pesos = new ArrayList<Double>();
	static List<Double> alturas = new ArrayList<Double>();
	
	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar\n"
				+ "2 - Avaliar\n\n"
				+ "3 - Sair";
		
		int op = 0 ;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if( op == 1) {
				cadastrar();
			}
			if( op == 2) {
				avaliar();
			}
		}while( op != 3);
		
	}
	
	public static void cadastrar() {
		nomes.add(JOptionPane.showInputDialog("Nome"));
		sexos.add(JOptionPane.showInputDialog("Sexo (M/F)"));
		pesos.add(Double.parseDouble(JOptionPane.showInputDialog("Peso")));
		alturas.add(Double.parseDouble(JOptionPane.showInputDialog("Altura")));
	}
	
	public static void avaliar() {
		String retorno = "IMCs\n\n";
		for(int i=0; i< nomes.size(); i++) {
			String nome = nomes.get(i);
			String sexo = sexos.get(i);
			double peso = pesos.get(i);
			double altura = alturas.get(i);
			double imc = peso / (altura * altura);
			String avaliacao = avaliaImc(sexo, imc);
			retorno += "\n" + nome + " - " + imc + " - " + avaliacao;
		}
		JOptionPane.showMessageDialog(null, retorno);
	}
	
	private static String avaliaImc(String sexo, double imc) {
		if(sexo.equalsIgnoreCase("M")) {
			if(imc < 20) {
				return "Abaixo do peso";
			}else {
				if(imc > 30) {
					return "Acima do peso";
				}else {
					return "Peso normal";
				}
			}
		}
		if(sexo.equalsIgnoreCase("F")) {
			if(imc < 15) {
				return "Abaixo do peso";
			}else {
				if(imc > 25) {
					return "Acima do peso";
				}else {
					return "Peso normal";
				}
			}
		}
		
		return "Não foi possível avaliar";
	}
	
	
	

}
