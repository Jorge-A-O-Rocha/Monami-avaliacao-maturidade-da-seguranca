package evento.fatec.api.avaliacao;

import java.util.Date;

public record DadosListagemAvaliacao(
		Long id,
		Date dataAvaliacao,
		String diagnostico,
		String nivelAderencia,
		int pontuacao,
		Long clienteId,
		Long formularioId) {
			
	public DadosListagemAvaliacao (Avaliacao avaliacao) {
		this(avaliacao.getId(), avaliacao.getDataAvaliacao(),
			 avaliacao.getDiagnostico(), avaliacao.getNivelAderencia(), avaliacao.getPontuacao(),
			 avaliacao.getClienteId(), avaliacao.getFormularioId());
		
	}

}