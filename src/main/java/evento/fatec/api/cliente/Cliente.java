package evento.fatec.api.cliente;


import java.util.List;

import evento.fatec.api.avaliacao.Avaliacao;
import evento.fatec.api.formulario.Formulario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name ="cliente")
@Entity(name ="cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Cliente {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="cliente_id")
	private Long id;
	private String cnpj;
	private String descricaoServico;
	private String email;
	private String emailCliente;
	private String idContrato;
	private String nomeCliente;
	private String nomeEmpresa;
	private String nomeGestor;
	private String pontoFocal;
	private String razaoSocial;
	private String senha;
	private String tipoServico;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Formulario> formulario;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;
	
	
	public Cliente() {
		
	}
	

	public Cliente (DadosCadastroCliente dados, List<Formulario> formulario, 
			List<Avaliacao> avaliacoes) {
		this.cnpj = dados.cnpj();
		this.descricaoServico = dados.descricaoServico();
		this.email = dados.email();
		this.emailCliente = dados.emailCliente();
		this.idContrato = dados.idContrato();
		this.nomeCliente = dados.nomeCliente();
		this.nomeEmpresa = dados.nomeEmpresa();
		this.nomeGestor = dados.nomeGestor();
		this.pontoFocal = dados.pontoFocal();
		this.razaoSocial = dados.razaoSocial();
		this.senha = dados.senha();
		this.tipoServico = dados.tipoServico();
		this.formulario = formulario;
		this.avaliacoes = avaliacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeGestor() {
		return nomeGestor;
	}

	public void setNomeGestor(String nomeGestor) {
		this.nomeGestor = nomeGestor;
	}

	public String getPontoFocal() {
		return pontoFocal;
	}

	public void setPontoFocal(String pontoFocal) {
		this.pontoFocal = pontoFocal;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public List<Formulario> getFormulario() {
		return formulario;
	}

	public void setFormulario(List<Formulario> formulario) {
		this.formulario = formulario;
	}


	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}


	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public Long getFormularioId() {
        return formulario != null ? ((Formulario) formulario).getId() : null;
    }
	
	public Long getAvaliacaoId() {
        return avaliacoes != null ? ((Avaliacao) avaliacoes).getId() : null;
    }

	public void atualizarInformacoes(@Valid DadosAtualizacaoCliente dados, List<Formulario> formulario, 
			List<Avaliacao> avaliacoes) {
		if(dados.nomeCliente() != null)
		    this.cnpj = dados.cnpj();
		    this.descricaoServico = dados.descricaoServico();
		    this.email = dados.email();
		    this.emailCliente = dados.emailCliente();
		    this.idContrato = dados.idContrato();
			this.nomeCliente = dados.nomeCliente();
			this.nomeEmpresa = dados.nomeEmpresa();
			this.nomeGestor = dados.nomeGestor();
			this.pontoFocal = dados.pontoFocal();
			this.razaoSocial = dados.razaoSocial();
			this.senha = dados.senha();
			this.tipoServico = dados.tipoServico();
			this.formulario = formulario;
			this.avaliacoes = avaliacoes;
	}
}
