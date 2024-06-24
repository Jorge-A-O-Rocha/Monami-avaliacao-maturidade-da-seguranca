package evento.fatec.api.formulario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import evento.fatec.api.cliente.Cliente;
import evento.fatec.api.cliente.ClienteService;

@Service
public class FormularioService {

	@Autowired
	private FormularioRepository repository;

	@Autowired
	private ClienteService clienteService;

	public List<Formulario> getAllFormulario() {
		return repository.findAll(Sort.by("id").ascending());
	}

	public Optional<Formulario> getFormularioById(Long id) {
        return repository.findById(id);
    }

    public Page<Formulario> findByNomeEmpresa(String nomeEmpresa, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByClienteNomeEmpresaContainingIgnoreCase(nomeEmpresa, pageable);
    }

	@Transactional
	public Formulario createFormulario(DadosCadastroFormulario dados) {
		Cliente cliente = clienteService.getClienteById(dados.clienteId()); // Obtém o cliente pelo ID
		Formulario formulario = new Formulario(dados, cliente);
		return repository.save(formulario);
	}

	@Transactional
	public Formulario updateFormulario(DadosAtualizacaoFormulario dados) {
		Formulario formulario = repository.findById(dados.id())
				.orElseThrow(() -> new IllegalArgumentException("Formulário não encontrado"));
		formulario.atualizarInformacoes(dados);
		return repository.save(formulario);
	}

	@Transactional
	public void deleteFormulario(Long id) {
		repository.deleteById(id);
	}
}
