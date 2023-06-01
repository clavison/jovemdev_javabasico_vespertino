package exemplo_polimorfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PolimorfismoTest {

	private List<Forma> lista = new ArrayList<Forma>();

	@BeforeEach
	public void init() {
		lista.add(new Circulo(3));
		lista.add(new Cone());
		lista.add(new Quadrado());
		lista.add(new Triangulo());
	}

	@Test
	@DisplayName("Teste desenhar círculo")
	public void desenharCirculoTest() {
		String s = lista.get(0).desenhar();
		assertEquals("Desenhando um Círculo", s);
	}

	@Test
	@DisplayName("Teste área círculo")
	public void areaCirculoTest() {
		Circulo c = (Circulo) lista.get(0);
		double area = c.calculaArea();
		DecimalFormat df = new DecimalFormat("##.00");
		assertEquals("28,27", df.format(area));
	}

}
