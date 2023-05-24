package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Carro {
	
	String marca;
	int ano;
	EnumCor cor;
	
	void cadastra(){
		marca = JOptionPane.showInputDialog("Marca");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano"));
		cor = EnumCor.escolheCor();
		if(!valida())
			cadastra();
	}
	
	boolean valida() {
		if(marca.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Marca obrigatório");
			return false;
		}
		if(ano <= 0 || ano > 2025) {
			JOptionPane.showMessageDialog(null, "Ano inválido");
			return false;
		}
		if( cor == null) {
			JOptionPane.showMessageDialog(null, "Cor inválida");
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Marca: "+ marca + "\n"
				+ "Ano: " + ano + "\n"
				+ "Cor: " + cor.descricao+"\n"
				+ "_____________\n";
	}
	
	boolean isFabricadoPeriodo(int anoI, int anoF) {
		return ano >= anoI && ano <= anoF;
	}
	
	boolean isMarca(String marcaBusca) {
		return marcaBusca.equalsIgnoreCase(marca);
	}
	
	boolean isCor(EnumCor cor) {
		return cor == this.cor;
	}
	

}
