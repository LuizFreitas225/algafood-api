package com.freitas.luiz.algafoodapi.api.controller;

import java.util.List;

import com.freitas.luiz.algafoodapi.domain.model.Cozinha;
import com.freitas.luiz.algafoodapi.domain.repository.CozinhaRepository;
import com.freitas.luiz.algafoodapi.model.CozinhasWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping()
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasWrapper listarXml() {
		return new CozinhasWrapper(cozinhaRepository.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> findById(@PathVariable Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);

		if(cozinha != null){
			return ResponseEntity.ok(cozinha);
		}

		return  ResponseEntity.notFound().build();
	}
}
