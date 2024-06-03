package evento.fatec.api.formulario;

import evento.fatec.api.avaliacao.Avaliacao;
import evento.fatec.api.cliente.Cliente;
import jakarta.persistence.CascadeType;
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
@Table(name ="formulario")
@Entity(name ="formulario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Formulario {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="formulario_id")
	private Long id;
	private boolean possuiControle;
	private int[] vetResposta;
	
	@OneToOne(mappedBy = "formulario", cascade = CascadeType.ALL)
	private Avaliacao avaliacao;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Formulario() {
		
	}

	public Formulario(DadosCadastroFormulario dados) {
		this.possuiControle = dados.possuiControle();
		this.vetResposta = dados.vetResposta(); 
		this.avaliacao = dados.avaliacao();
		this.cliente = dados.cliente();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPossuiControle() {
		return possuiControle;
	}

	public void setPossuiControle(boolean possuiControle) {
		this.possuiControle = possuiControle;
	}

	public int[] getVetResposta() {
		return vetResposta;
	}

	public void setVetResposta(int[] vetResposta) {
		this.vetResposta = vetResposta;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
    public Long getClienteId() {
        return cliente != null ? cliente.getId() : null;
    }
    
    public Long getAvaliacaoId() {
        return avaliacao != null ? avaliacao.getId() : null;
    }
    
	public void atualizarInformacoes(@Valid DadosAtualizacaoFormulario dados) {
		if(dados.id() != null)
			this.id = dados.id();
		    this.possuiControle = dados.possuiControle();
		    this.vetResposta = dados.vetResposta();
		    this.avaliacao = dados.avaliacao();
		    this.cliente = dados.cliente();
		    
		    
	}

	
}