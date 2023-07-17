package br.com.banco.dto;

import java.time.OffsetDateTime;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import br.com.banco.models.TipoDeTransacao;
import br.com.banco.models.Transferencia;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TransferenciaDTO {
	
	private Long id;

	private OffsetDateTime dataDeTransferencia;

	private Double valor;

	private TipoDeTransacao tipo;

	private String nomeDoOperadorDaTransacao;
	
	public TransferenciaDTO(Transferencia transferencia) {
		BeanUtils.copyProperties(transferencia, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getDataDeTransferencia() {
		return dataDeTransferencia;
	}

	public void setDataDeTransferencia(OffsetDateTime dataDeTransferencia) {
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

	public String getNomeDoOperadorDaTransacao() {
		return nomeDoOperadorDaTransacao;
	}

	public void setNomeDoOperadorDaTransacao(String nomeDoOperadorDaTransacao) {
		this.nomeDoOperadorDaTransacao = nomeDoOperadorDaTransacao;
	}
	
	

}
