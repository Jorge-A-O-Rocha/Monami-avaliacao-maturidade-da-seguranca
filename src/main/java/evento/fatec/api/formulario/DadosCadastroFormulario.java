package evento.fatec.api.formulario;

import evento.fatec.api.avaliacao.Avaliacao;
import evento.fatec.api.cliente.Cliente;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFormulario(
		@NotNull
		boolean possuiControle,
		int[] vetResposta,
		Avaliacao avaliacao,
		Cliente cliente) {

}
