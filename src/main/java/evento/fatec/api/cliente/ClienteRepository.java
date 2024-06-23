package evento.fatec.api.cliente;

import java.util.List;

//import org.springfremework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);

}