package evento.fatec.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evento.fatec.api.cliente.Cliente;
import evento.fatec.api.cliente.ClienteRepository;
import evento.fatec.api.cliente.ClienteService;
import evento.fatec.api.cliente.DadosAtualizacaoCliente;
import evento.fatec.api.cliente.DadosCadastroCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController { 
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if (id != null) {
			var cliente = repository.getReferenceById(id);
			model.addAttribute("cliente", cliente);
		}
		return "cliente/formulario";
	}
	@GetMapping
	public String carregaPaginaListagem (Model model) {
		model.addAttribute("lista", repository.findAll(Sort.by("nomeCliente").ascending()));
		return "cliente/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroCliente dados) {
		repository.save(new Cliente(dados, null, null));
		return "redirect:cliente";
	}	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoCliente dados) {
		var cliente = repository.getReferenceById(dados.id());
		cliente.atualizarInformacoes(dados, null, null);
		return "redirect:cliente";
	}
	
	@DeleteMapping
	@Transactional
	public String removeCliente(Long id) {
		repository.deleteById(id);
		return "redirect:cliente";
	}
	
	@GetMapping("/novo")
    public String chamarProcedimento() {
        clienteService.executarProcedimentoInserirDados();
        return "redirect:/cliente";
    }
	

}