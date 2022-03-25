package com.freitas.luiz.algafoodapi.domain.repository;


import com.freitas.luiz.algafoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);
	
}
