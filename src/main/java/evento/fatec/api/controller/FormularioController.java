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

import evento.fatec.api.formulario.DadosAtualizacaoFormulario;
import evento.fatec.api.formulario.DadosCadastroFormulario;
import evento.fatec.api.formulario.Formulario;
import evento.fatec.api.formulario.FormularioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/formulario")
public class FormularioController { 
	
	@Autowired
	private FormularioRepository repository;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if (id != null) {
			var formulario = repository.getReferenceById(id);
			model.addAttribute("formulario", formulario);
		}
		return "formulario/formulario";
	}
	@GetMapping
	public String carregaPaginaListagem (Model model) {
		model.addAttribute("lista", repository.findAll(Sort.by("id").ascending()));
		return "formulario/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroFormulario dados) {
		repository.save(new Formulario(dados));
		return "redirect:formulario";
	}	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoFormulario dados) {
		var formulario = repository.getReferenceById(dados.id());
		formulario.atualizarInformacoes(dados);
		return "redirect:formulario";
	}
	
	@DeleteMapping
	@Transactional
	public String removeFormulario(Long id) {
		repository.deleteById(id);
		return "redirect:formulario";
	}
	

}