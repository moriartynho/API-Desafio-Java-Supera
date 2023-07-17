package br.com.banco.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.banco.models.enums.TipoDeTransacao;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_transferencia")
	private LocalDateTime dataDeTransferencia;

	@Column(name = "valor")
	private Double valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoDeTransacao tipo;

	@Column(name = "nome_operador_transacao")
	private String nomeOperadorTransacao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public Transferencia() {
	}

	public Transferencia(Long id, LocalDateTime dataDeTransferencia, Double valor, TipoDeTransacao tipo,
			String nomeOperadorTransacao, Conta conta) {
		this.id = id;
		this.dataDeTransferencia = dataDeTransferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nomeOperadorTransacao = nomeOperadorTransacao;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataDeTransferencia() {
		return dataDeTransferencia;
	}

	public void setDataDeTransferencia(LocalDateTime dataDeTransferencia) {
		this.dataDeTransferencia = dataDeTransferencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoDeTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTransacao tipo) {
		this.tipo = tipo;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
