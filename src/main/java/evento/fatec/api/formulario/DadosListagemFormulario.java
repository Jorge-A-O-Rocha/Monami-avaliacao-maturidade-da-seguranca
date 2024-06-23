package evento.fatec.api.formulario;

import java.time.LocalDateTime;

public record DadosListagemFormulario(Long id, int pergunta1, int pergunta2, int pergunta3, int pergunta4,
		int pergunta5, LocalDateTime dataAvaliacao, String diagnostico, String nivelAderencia, int pontuacao,
		Long clienteId) {
	public DadosListagemFormulario(Formulario formulario) {
		this(formulario.getId(), formulario.getPergunta1(), formulario.getPergunta2(), formulario.getPergunta3(),
				formulario.getPergunta4(), formulario.getPergunta5(), formulario.getDataAvaliacao(),
				formulario.getDiagnostico(), formulario.getNivelAderencia(), formulario.getPontuacao(),
				formulario.getClienteId());
	}
}
