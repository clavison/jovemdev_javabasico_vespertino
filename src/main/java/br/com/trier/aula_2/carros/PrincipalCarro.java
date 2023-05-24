package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrincipalCarro {
	
	public static void main(String[] args) {
		List<Carro> lista = new ArrayList<Carro>();
		int op = 0;
		do {
			op = Util.opMenu();
			switch (op) {
			case 1:
				Carro c = new Carro();
				c.cadastra();
				lista.add(c);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, Util.buscarPorPeriodo(lista));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, Util.buscarPorMarca(lista));
				break;
			case 4:
				JOptionPane.showMessageDialog(null, Util.buscarPorCor(lista));
				break;
			}
		}while(op!=5);
	}

}
