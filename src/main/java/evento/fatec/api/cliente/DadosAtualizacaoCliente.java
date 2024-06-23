package evento.fatec.api.cliente;

import evento.fatec.api.formulario.Formulario;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
	@NotNull
	 Long id,
	 String cnpj,
	 String descricaoServico,
	 String email,
	 String emailCliente,
	 String idContrato,
	 String nomeCliente,
	 String nomeEmpresa,
	 String nomeGestor,
	 String pontoFocal,
	 String razaoSocial,
	 String senha,
	 String tipoServico,
	 Formulario formulario) {
		
}

