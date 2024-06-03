package evento.fatec.api.avaliacao;


import java.util.Date;

import evento.fatec.api.cliente.Cliente;
import evento.fatec.api.formulario.Formulario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name ="avaliacao")
@Entity(name ="avaliacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Avaliacao {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id_avaliacao")
	private Long id;
	private Date dataAvaliacao;
	private String diagnostico;
	private String nivelAderencia;
	private int pontuacao;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;
	
	
	public Avaliacao() {
		
	}
	
	public Avaliacao(DadosCadastroAvaliacao dados) {
		this.dataAvaliacao = dados.dataAvaliacao();
		this.diagnostico = dados.diagnostico();
		this.nivelAderencia = dados.nivelAderencia();
		this.pontuacao = dados.pontuacao();
		this.cliente = dados.cliente();
		this.formulario = dados.formulario();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getNivelAderencia() {
		return nivelAderencia;
	}

	public void setNivelAderencia(String nivelAderencia) {
		this.nivelAderencia = nivelAderencia;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}
	
	public Long getClienteId() {
        return cliente != null ? cliente.getId() : null;
    }
	
	public Long getFormularioId() {
        return formulario != null ? formulario.getId() : null;
    }

	public void atualizarInformacoes(@Valid DadosAtualizacaoAvaliacao dados) {
		if(dados.id() != null)
			this.id = dados.id();
		    this.dataAvaliacao = dados.dataAvaliacao();
		    this.diagnostico = dados.diagnostico();
		    this.nivelAderencia = dados.nivelAderencia();
		    this.pontuacao = dados.pontuacao();
		    
	}
}
