package com.freitas.luiz.algafoodapi.api.controller;

import java.util.List;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.freitas.luiz.algafoodapi.domain.model.Cozinha;
import com.freitas.luiz.algafoodapi.domain.repository.CozinhaRepository;
import com.freitas.luiz.algafoodapi.model.CozinhasWrapper;
import org.springframework.beans.BeanUtils;
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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody  Cozinha cozinha) {
		return  cozinhaRepository.salvar(cozinha);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cozinha> atualizar(@RequestBody  Cozinha cozinha,@PathVariable Long id) {
		Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
        if(cozinhaAtual != null){
			BeanUtils.copyProperties(cozinha,cozinhaAtual, "id");

			cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual) ;
		}
		return  ResponseEntity.notFound().build();
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cozinha> deletar(@RequestBody  Cozinha cozinha,@PathVariable Long id) {
		Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
		if(cozinhaAtual != null){
			cozinhaRepository.remover(cozinhaAtual);
			return  ResponseEntity.noContent().build();
		}
		return  ResponseEntity.notFound().build();
	}
}
