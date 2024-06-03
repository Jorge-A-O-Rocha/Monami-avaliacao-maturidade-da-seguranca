package evento.fatec.api.formulario;

public record DadosListagemFormulario(
		Long id,
		boolean possuiControle,
		int[] vetResposta,
		Long avaliacaoId,
		Long clienteId) {
			
	public DadosListagemFormulario (Formulario formulario) {
		this(formulario.getId(), formulario.isPossuiControle(), formulario.getVetResposta(),
			 formulario.getAvaliacaoId(), formulario.getClienteId());
		
	}

}