package br.com.banco.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.services.ContaService;

@RestController
@RequestMapping("/conta")
@CrossOrigin("*")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping(path = "/transferencias/{id}")
	public List<TransferenciaDTO> retornarTodasAsTransferenciasDeUmUsuarioComFiltroDeTempo(
			@PathVariable Long id,
			@RequestParam(required = false) OffsetDateTime dataInicio,
			@RequestParam(required = false) OffsetDateTime dataFim) {
		
		if (dataInicio == null && dataFim == null) {
			return contaService.retornarTodasAsTransferenciasDeUmUsuario(id);
		}
		return contaService.retornarTodasAsTransferenciasDeUmUsuarioComFiltroDeData(id, dataInicio, dataFim);
	}

}
