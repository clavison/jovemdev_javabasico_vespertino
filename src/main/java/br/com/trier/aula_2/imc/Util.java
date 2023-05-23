package br.com.trier.aula_2.imc;

import javax.swing.JOptionPane;

public class Util {
	
	static int escolheOp() {
		String menu = "1 - Cadastrar\n"
				+ "2 - Avaliar\n\n"
				+ "3 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
