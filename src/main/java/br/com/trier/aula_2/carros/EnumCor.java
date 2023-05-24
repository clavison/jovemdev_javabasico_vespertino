package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public enum EnumCor {
	
	PRETO (1, "Preto"),
	BRANCO (2, "Branco"),
	AZUL (3, "Azul"),
	VERMELHO (4, "Vermelho"),
	PRATA (0, "Prata");
	
	int codigo;
	String descricao;
	
	private EnumCor(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	static EnumCor buscaPorCodigo(int codigo) {
		for(EnumCor cor: EnumCor.values()) {
			if(codigo == cor.codigo) {
				return cor;
			}
		}
		return null;
	}
	
	static EnumCor escolheCor() {
		String menu = "Escolhas uma cor:\n";
		for (EnumCor cor : EnumCor.values()) {
			menu += cor.codigo + " - " + cor.descricao + "\n";
		}
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return buscaPorCodigo(escolha);
	}
	
	
	
	

}
