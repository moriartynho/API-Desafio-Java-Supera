package br.com.banco.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(path = "{id}/transferencias")
	public ResponseEntity<List<TransferenciaDTO>> retornarTodasAsTransferenciasDeUmUsuario(@PathVariable Long id,
			String dataInicio, String dataFim) {

		
		List<TransferenciaDTO> dto = contaService.retornarTodasAsTransferenciasDeUmUsuario(id, dataInicio,
				dataFim);
		return ResponseEntity.ok().body(dto);

	}

	@GetMapping(path = "{id}/transferencias/{nomeDoOperador}")
	public ResponseEntity<List<TransferenciaDTO>> retornarTodasAsTransferenciasComNomeDeOperador(@PathVariable Long id,
			@PathVariable String nomeDoOperador,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") OffsetDateTime dataInicio,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") OffsetDateTime dataFim) {

		List<TransferenciaDTO> dto = contaService.retornarTodasAsTransferenciasDeUmUsuarioComNomeDeOperador(id,
				dataInicio, dataFim, nomeDoOperador);
		return ResponseEntity.ok().body(dto);
	}

}
