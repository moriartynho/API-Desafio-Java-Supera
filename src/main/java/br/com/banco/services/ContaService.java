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

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<TransferenciaDTO> retornarTodasAsTransferenciasDeUmUsuario(Long id) {
		List<Transferencia> transferencias = transferenciaRepository.findByContaId(id);
		List<TransferenciaDTO> dto = transferencias.stream().map(x -> new TransferenciaDTO(x)).toList();
		return dto;
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<TransferenciaDTO> retornarTodasAsTransferenciasDeUmUsuarioComFiltroDeData(Long id,
			OffsetDateTime dataInicio, OffsetDateTime dataFim) {
		
		List<Transferencia> transferencias = transferenciaRepository.findByContaIdBetween(id, dataInicio,
				dataFim);
		List<TransferenciaDTO> dto = transferencias.stream().map(x -> new TransferenciaDTO(x)).toList();
		return dto;

	}

}
