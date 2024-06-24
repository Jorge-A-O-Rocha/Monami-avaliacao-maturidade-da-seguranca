package evento.fatec.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import evento.fatec.api.formulario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

	@Autowired
	private FormularioService service;
	

	@GetMapping("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if (id != null) {
			var formulario = service.getFormularioById(id).orElse(null);
			model.addAttribute("formulario", formulario);
		}
		return "formulario/formulario";
	}

	@GetMapping
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("lista", service.getAllFormulario());
		return "formulario/listagem";
	}
	
	@GetMapping("/pesquisa")
    public String pesquisaFormulario(@RequestParam(name = "nomeEmpresa", required = false) String nomeEmpresa,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "10") int size,
                                     Model model) {
        if (nomeEmpresa != null && !nomeEmpresa.isEmpty()) {
            Page<Formulario> formularios = service.findByNomeEmpresa(nomeEmpresa, page, size);
            model.addAttribute("lista", formularios.getContent());
            model.addAttribute("page", formularios);
        } else {
            model.addAttribute("lista", service.getAllFormulario());
        }
        model.addAttribute("nomeEmpresa", nomeEmpresa);
        return "formulario/listagem";
    }


	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroFormulario dados) {
		service.createFormulario(dados);
		return "redirect:formulario";
	}

	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoFormulario dados) {
		service.updateFormulario(dados);
		return "redirect:formulario";
	}

	@DeleteMapping
	@Transactional
	public String removeFormulario(Long id) {
		service.deleteFormulario(id);
		return "redirect:formulario";
	}
}
