package evento.fatec.api.formulario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class FormularioService {
	@Autowired
	private  FormularioRepository repository;
	
	public List<Formulario> getAllFormulario() {
		return repository.findAll(Sort.by("id").ascending());
	}
	
	public Formulario getFormularioById (Long id) {
		return  repository.getReferenceById(id);
	}
}
