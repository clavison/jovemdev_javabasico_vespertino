package exercicio_medicamamento.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_medicamamento.models.Medicamento;
import exercicio_medicamamento.models.Pessoa;

class MedicoTest {
	
	private Medico medico = new Medico();
	
	@BeforeEach
	public void init() {
		medico.getMedicamentos().clear();
		medico.getPessoas().clear();
		
		Pessoa p1 = new Pessoa("Pessoa 1", "Gripe");
		p1.addCondicaoSaude("Dengue");
		p1.addCondicaoSaude("Diabetes");
		Pessoa p2 = new Pessoa("Pessoa 2", "Dor");
		medico.cadastraPessoa(p1);
		medico.cadastraPessoa(p2);
		
		Medicamento m1 = new Medicamento("Med 1");
		m1.addIndicacao("Dor");
		m1.addContraIndicacao("Pressão alta");
		
		Medicamento m2 = new Medicamento("Med 2");
		m2.addIndicacao("Gripe");
		m2.addIndicacao("Febre");
		m2.addContraIndicacao("Dengue");
		
		Medicamento m3 = new Medicamento("Med 3");
		m3.addIndicacao("Gripe");
		
		medico.cadastraMedicamento(m1);
		medico.cadastraMedicamento(m2);
		medico.cadastraMedicamento(m3);
		
	}

	@Test
	void prescreverOk() {
		Pessoa p = medico.getPessoas().get(0);
		Medicamento m = medico.getMedicamentos().get(2);
		boolean prescrito = medico.prescreveMedicamento(p, m);
		assertEquals(true, prescrito);
		assertEquals(1, p.getMedicamentos().size());
		assertEquals("Med 3", p.getMedicamentos().get(0).getNome());
	}
	
	@Test
	void prescreverFalhaIndicacao() {
		Pessoa p = medico.getPessoas().get(0);
		Medicamento m = medico.getMedicamentos().get(0);
		boolean prescrito = medico.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	void prescreverFalhaContraIndicacao() {
		//fail("Not yet implemented");
	}

}
