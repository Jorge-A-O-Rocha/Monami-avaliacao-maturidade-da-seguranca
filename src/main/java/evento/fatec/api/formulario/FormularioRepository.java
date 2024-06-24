package evento.fatec.api.formulario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {

    Page<Formulario> findByClienteNomeEmpresaContainingIgnoreCase(String nomeEmpresa, Pageable pageable);
}