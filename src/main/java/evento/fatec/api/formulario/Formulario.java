package evento.fatec.api.formulario;

import java.time.LocalDateTime;

import evento.fatec.api.cliente.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "formulario")
@Entity(name = "formulario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Formulario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formulario_id")
	private Long id;
	@NotNull
	private int pergunta1;
	@NotNull
	private int pergunta2;
	@NotNull
	private int pergunta3;
	@NotNull
	private int pergunta4;
	@NotNull
	private int pergunta5;

	private LocalDateTime dataAvaliacao;
	private String diagnostico;
	private String nivelAderencia;
	private int pontuacao;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Formulario() {

	}

	public Formulario(DadosCadastroFormulario dados, Cliente cliente) {
		this.pergunta1 = dados.pergunta1();
		this.pergunta2 = dados.pergunta2();
		this.pergunta3 = dados.pergunta3();
		this.pergunta4 = dados.pergunta4();
		this.pergunta5 = dados.pergunta5();
		this.dataAvaliacao = LocalDateTime.now();
		this.cliente = cliente;
		calcularPontuacaoDiagnosticoNivel();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoFormulario dados) {
		this.pergunta1 = dados.pergunta1();
		this.pergunta2 = dados.pergunta2();
		this.pergunta3 = dados.pergunta3();
		this.pergunta4 = dados.pergunta4();
		this.pergunta5 = dados.pergunta5();
		this.dataAvaliacao = LocalDateTime.now();
		this.diagnostico = dados.diagnostico();
		this.nivelAderencia = dados.nivelAderencia();
		calcularPontuacaoDiagnosticoNivel();
	}

	public LocalDateTime getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPergunta1() {
		return pergunta1;
	}

	public void setPergunta1(int pergunta1) {
		this.pergunta1 = pergunta1;
	}

	public int getPergunta2() {
		return pergunta2;
	}

	public void setPergunta2(int pergunta2) {
		this.pergunta2 = pergunta2;
	}

	public int getPergunta3() {
		return pergunta3;
	}

	public void setPergunta3(int pergunta3) {
		this.pergunta3 = pergunta3;
	}

	public int getPergunta4() {
		return pergunta4;
	}

	public void setPergunta4(int pergunta4) {
		this.pergunta4 = pergunta4;
	}

	public int getPergunta5() {
		return pergunta5;
	}

	public void setPergunta5(int pergunta5) {
		this.pergunta5 = pergunta5;
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

	private void calcularPontuacaoDiagnosticoNivel() {
		this.pontuacao = pergunta1 + pergunta2 + pergunta3 + pergunta4 + pergunta5;

		if (pontuacao <= 7) {
			this.diagnostico = "É preciso melhor a ciberhigiene";
			this.nivelAderencia = "Baixo";
		} else if (pontuacao <= 11) {
			this.diagnostico = "Um bom começo mas é preciso melhorar integridade";
			this.nivelAderencia = "Médio";
		} else {
			this.diagnostico = "Muito bom já possível ir para automação de processos";
			this.nivelAderencia = "Alto";
		}
	}

	public String getClienteCnpj() {
		return cliente != null ? cliente.getCnpj() : null;
	}

	public String getClienteEmpresa() {
		return cliente != null ? cliente.getNomeEmpresa() : null;
	}

}