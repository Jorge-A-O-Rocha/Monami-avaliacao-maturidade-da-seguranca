package evento.fatec.api.cliente;
//import org.springfremework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	@Modifying
    @Query(nativeQuery = true, value = "CALL inserir_dados_cliente()")
    void executarProcedimentoInserirDados();

}