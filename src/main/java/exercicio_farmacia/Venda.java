package exercicio_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Venda {
	
	@NonNull
	private Cliente cliente;
	@NonNull
	private Produto produto;
	@NonNull
	private Integer quantidade;
	
	private String medico;
	
	@Override
	public String toString() {
		return cliente.getNome() + "-" + produto.getNome()+"-"+(produto.getValor() + quantidade);
	}
	
	public boolean isCliente(Cliente c) {
		return c.getNome().equalsIgnoreCase(cliente.getNome());
	}

}
