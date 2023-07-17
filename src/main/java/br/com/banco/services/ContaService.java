package br.com.banco.services;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.models.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class ContaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@org.springframework.transaction.annotation.Transactional
	public List<TransferenciaDTO> retornarTodasAsTransferenciasDeUmUsuario(
			Long id, 
			OffsetDateTime dataInicio,
			OffsetDateTime dataFim) {

		if (dataInicio == null && dataFim == null) {
			List<Transferencia> transferencias = transferenciaRepository.findByContaId(id);
			List<TransferenciaDTO> dto = transferencias.stream().map(x -> new TransferenciaDTO(x)).toList();
			return dto;
		}

		List<Transferencia> transferencias = transferenciaRepository.findByContaIdBetween(id, dataInicio, dataFim);
		List<TransferenciaDTO> dto = transferencias.stream().map(x -> new TransferenciaDTO(x)).toList();
		return dto;

	}

	public List<TransferenciaDTO> retornarTodasAsTransferenciasDeUmUsuarioComNomeDeOperador(
			Long id, 
			OffsetDateTime dataFim,
			OffsetDateTime dataInicio, 
			String nomeDoOperador) {
		
		if (dataInicio == null && dataFim == null) {
			List<Transferencia> transferencias = transferenciaRepository.findByContaIdAndNomeOperadorTransacao(id, nomeDoOperador);
			List<TransferenciaDTO> dto = transferencias.stream().map(x -> new TransferenciaDTO(x)).toList();
			return dto;
		}

		List<Transferencia> transferencias = transferenciaRepository.findByContaIdBetweenAndNomeOperadorTransacao(id, dataInicio, dataFim, nomeDoOperador);
		List<TransferenciaDTO> dto = transferencias.stream().map(x -> new TransferenciaDTO(x)).toList();
		return dto;
	}

}
