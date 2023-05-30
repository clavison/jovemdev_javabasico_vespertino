package exercicio_medicamamento.models;

import java.util.ArrayList;
import java.util.List;

import exercicio_medicamamento.enums.EnumAdmMedicamento;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Medicamento {
	
	@NonNull
	private String nome;
	
	private EnumAdmMedicamento administracao = EnumAdmMedicamento.ORAL;
	private List<String> indicacoes = new ArrayList<String>();
	private List<String> contraIndicacoes = new ArrayList<String>();
	
	public void addIndicacao(String indicacao) {
		indicacoes.add(indicacao);
	}
	
	public void addContraIndicacao(String contraIndicacao) {
		contraIndicacoes.add(contraIndicacao);
	}
	
	public boolean isIndicado(String sintoma) {
		return indicacoes.contains(sintoma);
	}
	
	public boolean isContraIndicado(List<String> condicaoSaude) {
		return contraIndicacoes.stream().
				anyMatch(condicaoSaude :: contains);
	}
	

}
