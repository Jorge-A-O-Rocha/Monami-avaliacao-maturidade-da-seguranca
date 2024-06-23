package evento.fatec.api.cliente;

public record DadosListagemCliente(Long id, String cnpj, String descricaoServico, String email, String emailCliente,
		String idContrato, String nomeCliente, String nomeEmpresa, String nomeGestor, String pontoFocal,
		String razaoSocial, String tipoServico, Long formularioId) {

	public DadosListagemCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getCnpj(), cliente.getDescricaoServico(), cliente.getEmail(),
				cliente.getEmailCliente(), cliente.getIdContrato(), cliente.getNomeCliente(), cliente.getNomeEmpresa(),
				cliente.getNomeGestor(), cliente.getPontoFocal(), cliente.getRazaoSocial(), cliente.getTipoServico(),
				cliente.getFormularioId());

	}

}