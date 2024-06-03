package evento.fatec.api.avaliacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class AvaliacaoService {
	@Autowired
	private  AvaliacaoRepository repository;
	
	public List<Avaliacao> getAllAvaliacao() {
		return repository.findAll(Sort.by("id").ascending());
	}
	
	public Avaliacao getAvaliacaoById (Long id) {
		return  repository.getReferenceById(id);
	}
}
