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

import evento.fatec.api.avaliacao.Avaliacao;
import evento.fatec.api.avaliacao.AvaliacaoRepository;
import evento.fatec.api.avaliacao.DadosAtualizacaoAvaliacao;
import evento.fatec.api.avaliacao.DadosCadastroAvaliacao;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController { 
	
	@Autowired
	private AvaliacaoRepository repository;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if (id != null) {
			var avaliacao = repository.getReferenceById(id);
			model.addAttribute("avaliacao", avaliacao);
		}
		return "avaliacao/formulario";
	}
	
	@GetMapping
	public String carregaPaginaListagem (Model model) {
		model.addAttribute("lista", repository.findAll(Sort.by("id").ascending()));
		return "avaliacao/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroAvaliacao dados) {
		repository.save(new Avaliacao(dados));
		return "redirect:avaliacao";
	}	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoAvaliacao dados) {
		var avaliacao = repository.getReferenceById(dados.id());
		avaliacao.atualizarInformacoes(dados);
		return "redirect:avaliacao";
	}
	
	@DeleteMapping
	@Transactional
	public String removeAvaliacao(Long id) {
		repository.deleteById(id);
		return "redirect:avaliacao";
	}
	

}