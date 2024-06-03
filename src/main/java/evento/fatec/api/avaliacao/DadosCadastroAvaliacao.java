package evento.fatec.api.avaliacao;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import evento.fatec.api.cliente.Cliente;
import evento.fatec.api.formulario.Formulario;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAvaliacao(
		@NotNull
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	    Date dataAvaliacao,
		String diagnostico,
	    String nivelAderencia,
		int pontuacao,
		Cliente cliente,
		Formulario formulario) {

}
