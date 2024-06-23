package evento.fatec.api.formulario;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroFormulario(@NotNull int pergunta1, @NotNull int pergunta2, @NotNull int pergunta3,
		@NotNull int pergunta4, @NotNull int pergunta5, Long clienteId) {

}
