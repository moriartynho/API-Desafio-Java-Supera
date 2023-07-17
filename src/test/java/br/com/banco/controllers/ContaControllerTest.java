package br.com.banco.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.banco.services.ContaService;

@WebMvcTest(ContaController.class)
class ContaControllerTest {
	
	@MockBean
	ContaService contaService;
	
	@Autowired
	private MockMvc mockMvc;

//	@Test
//	void deveriaRetornarRetornarAsTransacoesDeUmUsuario() {
//		mockMvc.perform(post("localhost:8080/conta/1/transferencias"));
//	}

}
