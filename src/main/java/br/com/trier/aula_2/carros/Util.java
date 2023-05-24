package br.com.trier.aula_2.carros;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	
	static double calculaPercentual (List<Carro> carros, int qt) {
		return (double) qt / (double)carros.size() * 100;
	}
	
	static String buscarPorPeriodo(List<Carro> carros) {
		int anoI = Integer.parseInt(JOptionPane.showInputDialog("Ano inicial"));
		int anoF = Integer.parseInt(JOptionPane.showInputDialog("Ano final"));
		String ret = "Carros fabricados entre %s e %s\n".formatted(anoI, anoF);
		int count = 0;
		for(Carro c: carros) {
			if(c.isFabricadoPeriodo(anoI, anoF)) {
				count ++;
				ret += c.toString();
			}
		}
		ret += "Representa %s %% dos carros".formatted(calculaPercentual(carros, count));
		ret += "\n";
		
		return ret;
	}
	
	static String buscarPorMarca(List<Carro> carros) {
		String marca = JOptionPane.showInputDialog("Marca");
		String ret = "Carros da marca %s\n".formatted(marca);
		int count = 0;
		for(Carro c: carros) {
			if(c.isMarca(marca)) {
				count ++;
				ret += c.toString();
			}
		}
		ret += "Representa %s %% dos carros".formatted(calculaPercentual(carros, count));
		ret += "\n";
		
		return ret;
	}
	
	static String buscarPorCor(List<Carro> carros) {
		EnumCor cor = EnumCor.escolheCor();
		String ret = "Carros da cor %s\n".formatted(cor.descricao);
		int count = 0;
		for(Carro c: carros) {
			if(c.isCor(cor)) {
				count ++;
				ret += c.toString();
			}
		}
		ret += "Representa %s %% dos carros".formatted(calculaPercentual(carros, count));
		ret += "\n";
		
		return ret;
	}
	
	static int opMenu() {
		String menu = "1 – Cadastrar Carro\r\n"
				+ "2 – Listar os carros por período de fabricação\r\n"
				+ "3 – Listar carros por marca\r\n"
				+ "4 – Listar carros por cor\r\n"
				+ "5 – Sair \r\n";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
