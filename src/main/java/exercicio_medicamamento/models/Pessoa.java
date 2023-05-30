package exercicio_medicamamento.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Pessoa {
	
	@NonNull
	private String nome;
	
	@NonNull
	private String sintoma;
	
	private List<String> condicaoSaude = new ArrayList<String>();
	
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	public void addCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude.add(condicaoSaude);
	}
	
	public boolean addMedicamento(Medicamento m) {
		if(m.isIndicado(sintoma) && !m.isContraIndicado(condicaoSaude)) {
			medicamentos.add(m);
			return true;
		}
		return false;
	}

}
